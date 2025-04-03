package com.ranetejas03.question_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class QuestionDTO {

	
	private Integer id;
	private String questionTitle; 	//question_title
	private String option1;
	private String option2;
	private String option3;
	private String option4;
}
