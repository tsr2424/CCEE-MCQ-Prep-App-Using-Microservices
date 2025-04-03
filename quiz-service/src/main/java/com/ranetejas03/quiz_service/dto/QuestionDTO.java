package com.ranetejas03.quiz_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionDTO {

	
	private Integer id;
	private String questionTitle; 	//question_title
	private String option1;
	private String option2;
	private String option3;
	private String option4;
}
