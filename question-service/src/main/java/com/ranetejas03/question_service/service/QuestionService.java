package com.ranetejas03.question_service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ranetejas03.question_service.dto.QuestionDTO;
import com.ranetejas03.question_service.dto.ResponseDTO;
//import com.ranetejas03.question_service.controllers.ResponseEnitity;
import com.ranetejas03.question_service.entity.Question;

public interface QuestionService {

	public ResponseEntity<List<Question>> getAllQuestions();
	
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category);
	
	public ResponseEntity<String> addQuestion(Question question);
	
	public ResponseEntity<String> deleteQuestion(Integer id);

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numOfQuestions);

	public ResponseEntity<List<QuestionDTO>> getQuestionsFromId(List<Integer> questionIds);

	public ResponseEntity<Integer> getScore(List<ResponseDTO> responses);

}
