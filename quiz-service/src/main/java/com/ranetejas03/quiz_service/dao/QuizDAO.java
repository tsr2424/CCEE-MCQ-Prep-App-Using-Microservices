package com.ranetejas03.quiz_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranetejas03.quiz_service.entity.Quiz;

public interface QuizDAO extends JpaRepository<Quiz, Integer> {

}
