package com.ranetejas03.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ranetejas03.quiz_service.dto.QuestionDTO;
import com.ranetejas03.quiz_service.dto.ResponseDTO;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {	
	
	@GetMapping("/questions/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam int numOfQuestions);		//Integer
	
	@PostMapping("/questions/getQuestions")
	public ResponseEntity<List<QuestionDTO>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
	
	@PostMapping("/questions/getScore")
	public ResponseEntity<Integer> getScore (@RequestBody List<ResponseDTO> responses);


}
