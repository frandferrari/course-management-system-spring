package com.frandferrari.course_management_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frandferrari.course_management_system.entities.Students;
import com.frandferrari.course_management_system.repositories.StudentsRepository;

@RestController
@RequestMapping(value = "/students")
public class StudentsController {

	@Autowired
	private StudentsRepository repository;

	@GetMapping
	public List<Students> findAll() {
		List<Students> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public Students findById(@PathVariable Long id) {
		Students result = repository.findById(id).get();
		return result;
	}

	@PostMapping
	public Students insert(@RequestBody Students student) {
		Students result = repository.save(student);
		return result;
	}

}