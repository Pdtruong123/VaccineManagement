package com.vn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "News_Type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsType implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "news_type_id", length = 36)
	private String id;
	
	@Column(length = 10)
	private String description;
	
	@Column(length = 50, name = "news_type_name")
	private String newsTypeName;
	
	@OneToMany(mappedBy = "newType")
	private Set<News> news;
	
}
