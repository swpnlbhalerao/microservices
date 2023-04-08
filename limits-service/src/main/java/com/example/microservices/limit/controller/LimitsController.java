package com.example.microservices.limit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.configuration.Configuration;
import com.example.microservices.limit.bean.Limits;

@RestController
public class LimitsController {

	
	@Autowired
	private Configuration configuration;
	
	@GetMapping(path = "/limits")
	public Limits getAllLimits() {
		return new Limits(configuration.getMinimum(),configuration.getMaximum());
	}
}
