package com.ranetejas03.quiz_service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ranetejas03.quiz_service.dto.QuestionDTO;
import com.ranetejas03.quiz_service.dto.ResponseDTO;

public interface QuizService {

	public ResponseEntity<String> createQuiz(String category, int numOfQuestions, String title);
	
	public ResponseEntity<List<QuestionDTO>> getQuizQuestions(Integer id);
	
	public ResponseEntity<Integer> submitQuiz(Integer id, List<ResponseDTO> responses);
}
