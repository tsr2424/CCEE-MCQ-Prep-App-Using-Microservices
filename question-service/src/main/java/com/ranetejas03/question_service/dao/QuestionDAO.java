package com.ranetejas03.question_service.dao;

import java.util.List;

//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ranetejas03.question_service.entity.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{

//	public void getAllQuestions() {
//		// TODO Auto-generated method stub
//	}

	List<Question> findByCategory(String category);
	// Since category column is present in table, JPA auto fetches data by category
	// No need for hql or jpql

	@Query(value = "SELECT q.id FROM Question q WHERE q.category=:category ORDER BY RAND()", nativeQuery = true)
	List<Integer> findRandomQuestionByCategory(String category);
}
