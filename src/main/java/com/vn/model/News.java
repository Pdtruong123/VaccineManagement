package com.vn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "News")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class News {

	@Id
	@Column(name = "news_id", length = 36)
	private String id;
	
	@Column(length = 4000)
	private String content;
	
	@Column(length = 1000)
	private String preview;
	
	@Column(length = 300)
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "news_type_id")
	private NewsType newType;
	
}
