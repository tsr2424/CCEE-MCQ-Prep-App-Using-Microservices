package com.ranetejas03.quiz_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.ranetejas03.quiz_service.dao.QuestionDAO;
import com.ranetejas03.quiz_service.dao.QuizDAO;
import com.ranetejas03.quiz_service.dto.QuestionDTO;
import com.ranetejas03.quiz_service.dto.ResponseDTO;
//import com.ranetejas03.quiz_service.entity.Question;
import com.ranetejas03.quiz_service.entity.Quiz;
import com.ranetejas03.quiz_service.feign.QuizInterface;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	QuizDAO quizDAO;
	
	@Autowired
	QuizInterface quizInterface;
	//Use quizInterface instead of RestTemplate to make calls



	public ResponseEntity<String> createQuiz(String category, int numOfQuestions, String title) {		

		//IMPT
//		List<Integer>questions = // call the "generate" URL via RestTemplate http://localhost:8080/questions/generate
		// OR optimal solution
		List<Integer>questions = quizInterface.getQuestionsForQuiz(category, numOfQuestions).getBody();
		
		Quiz quiz = new Quiz();
		
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDAO.save(quiz);
		
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionDTO>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDAO.findById(id);
		//findByID always returns optional data
		List<Integer> questionsFromDB = quiz.get().getQuestionIds();
//		//Whenever using Optional, first get the object with get() then use custom methods
//		
		ResponseEntity<List<QuestionDTO>> questions = quizInterface.getQuestionsFromId(questionsFromDB);
		
		return questions;
	}

	public ResponseEntity<Integer> submitQuiz(Integer id, List<ResponseDTO> responses) {
		
		ResponseEntity<Integer> score = quizInterface.getScore(responses);
		
		return score;
	}
	
	
}
