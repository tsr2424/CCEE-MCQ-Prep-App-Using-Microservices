package com.ranetejas03.quiz_service.entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
//	@ManyToMany
//	private List<Question> questions;
	// Multiple quizzes can have multiple overlapping questions
	// For multi entries/objects

	@ElementCollection
	private List<Integer>questionIds;
}
