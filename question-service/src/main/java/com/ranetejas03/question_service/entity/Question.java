package com.ranetejas03.question_service.entity;

import jakarta.persistence.Entity;

//import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data						//Lombok all requirements
public class Question {
	
	@Id								//PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Auto Generate
	private Integer id;
	private String questionTitle; 	//question_title
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String rightAnswer; 	//right_answer
	private String difficultylevel; 	//difficultylevel
	private String category;
}
