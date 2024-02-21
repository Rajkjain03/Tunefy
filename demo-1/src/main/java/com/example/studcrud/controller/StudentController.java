package com.example.studcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@GetMapping("create")
	public String createStudent() {
		return "Creating";
	}
	
	@GetMapping("fetch")
	public String fetchStudent() {
		return "Fetching";
	}
}
