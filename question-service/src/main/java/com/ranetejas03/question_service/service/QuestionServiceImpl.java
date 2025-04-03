package com.ranetejas03.question_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.ranetejas03.mcqs.entity.Quiz;
import com.ranetejas03.question_service.dao.QuestionDAO;
import com.ranetejas03.question_service.dto.QuestionDTO;
import com.ranetejas03.question_service.dto.ResponseDTO;
import com.ranetejas03.question_service.entity.Question;

@Service 
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	QuestionDAO questionDAO;

//	public List<Question> getAllQuestions() {
//		return questionDAO.findAll();
//		
////		return questionDAO.getAllQuestions();
////		return null;
//	}
	public ResponseEntity<List<Question>> getAllQuestions(){
		try {
			return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// If fetching fails
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// If fetching fails
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
//		return null;
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionDAO.save(question);
//			return "success";
			return new ResponseEntity<>("success", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// If fetching fails
		return new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> deleteQuestion(Integer id) {
		try {
			questionDAO.deleteById(id);
			return new ResponseEntity<>("Questions deleted successfully!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("failed to delete", HttpStatus.BAD_REQUEST);
//		return null;
	}
	
	
	
	
	
	// Microservices
	
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numOfQuestions){
		List<Integer> questions = questionDAO.findRandomQuestionByCategory(categoryName);
		List<Integer> allQuestionsWithLimit = questions.stream().limit(numOfQuestions).collect(Collectors.toList());
		
		return new ResponseEntity<>(allQuestionsWithLimit, HttpStatus.OK);
		
	}

	
	public ResponseEntity<List<QuestionDTO>> getQuestionsFromId(List<Integer> questionIds){
		
		List<Question> questionsFromDb = new ArrayList<>();
		List<QuestionDTO> questionDTOList = new ArrayList<>();
		
		for(Integer id : questionIds) {
			questionsFromDb.add(questionDAO.findById(id).get());		//.get() cause findById returns Optional
		}
		
		for(Question ques : questionsFromDb) {
			QuestionDTO quesDTOIndividual = new QuestionDTO();
			quesDTOIndividual.setId(ques.getId());
			quesDTOIndividual.setQuestionTitle(ques.getQuestionTitle());
			quesDTOIndividual.setOption1(ques.getOption1());
			quesDTOIndividual.setOption2(ques.getOption2());
			quesDTOIndividual.setOption3(ques.getOption3());
			quesDTOIndividual.setOption4(ques.getOption4());
			
			questionDTOList.add(quesDTOIndividual);
			
		}
		
		return new ResponseEntity<>(questionDTOList, HttpStatus.OK);
	}
	
	
	public ResponseEntity<Integer> getScore(List<ResponseDTO> responses){

		int correctAnswer = 0;
		
		for (ResponseDTO rDTO : responses) {
			Question question = questionDAO.findById(rDTO.getId()).get();

			if (rDTO.getResponse().equals(question.getRightAnswer())) {
				correctAnswer++;
			}
		}
		
		return new ResponseEntity<>(correctAnswer, HttpStatus.OK);
	}


}
