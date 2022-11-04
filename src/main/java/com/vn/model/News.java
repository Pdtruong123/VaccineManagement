package com.vn.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "News")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class News extends BaseModel{

	@Id
	@Column(name = "news_id", length = 36)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newsId")
	@GenericGenerator(name="newsId", strategy = "com.vn.model.GenerateNewsId",
			parameters = {
					@org.hibernate.annotations.Parameter(name = GenerateNewsId.INCREMENT_PARAM, value = "1"),
					@org.hibernate.annotations.Parameter(name = GenerateNewsId.NUMBER_FORMAT_PARAMETER, value = "%05d")
			} )

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
