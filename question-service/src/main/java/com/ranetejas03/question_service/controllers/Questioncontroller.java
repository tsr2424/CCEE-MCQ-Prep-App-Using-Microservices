package com.ranetejas03.question_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ranetejas03.question_service.dto.QuestionDTO;
import com.ranetejas03.question_service.dto.ResponseDTO;
import com.ranetejas03.question_service.entity.Question;
import com.ranetejas03.question_service.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class Questioncontroller {
	
	@Autowired
	QuestionService questionService;

	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
//		return "Test successful!";
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
//		return "success";
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
		return questionService.deleteQuestion(id);
	}
	
	
	
	//Microservices
	@GetMapping("/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz
	(@RequestParam String categoryName, @RequestParam Integer numOfQuestions){
		return questionService.getQuestionsForQuiz(categoryName, numOfQuestions);
	}
	
	@PostMapping("/getQuestions")
	public ResponseEntity<List<QuestionDTO>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
		return questionService.getQuestionsFromId(questionIds);
	}
	
	@PostMapping("/getScore")
	public ResponseEntity<Integer> getScore (@RequestBody List<ResponseDTO> responses){
		return questionService.getScore(responses);
	}
}
