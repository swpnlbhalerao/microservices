package com.ssb.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssb.model.Course;

@RestController
public class CourseController {

	
	@Autowired
	CurrencyServiceConfiguration config;
	
	@GetMapping("/courses")
	public List<Course> retAllCourses(){
		
		return Arrays.asList(
				new Course(1,"ABC","SSB"),
				new Course(2,"ADX","SSB1"),
				new Course(3,"MNN","SSB2")
				);
		
	}
	@GetMapping("/config")
	public CurrencyServiceConfiguration retConfig(){
		
		return config;
	}
}
