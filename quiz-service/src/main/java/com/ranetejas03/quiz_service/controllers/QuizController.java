package com.ranetejas03.quiz_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ranetejas03.quiz_service.dto.QuestionDTO;
import com.ranetejas03.quiz_service.dto.QuizDTO;
import com.ranetejas03.quiz_service.dto.ResponseDTO;
import com.ranetejas03.quiz_service.service.QuizServiceImpl;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizServiceImpl quizService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){
		return quizService.createQuiz(quizDTO.getCategory(), quizDTO.getNumOfQuestions(), quizDTO.getTitle());
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionDTO>> getQuizQuestions(@PathVariable Integer id){
		return quizService.getQuizQuestions(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<ResponseDTO> responses){
		return quizService.submitQuiz(id, responses);
	}

}
