package com.ssb.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ssb.controller.CourseController;
import com.ssb.rest.helloworld.HelloWorldController;

@SpringBootApplication
//@ComponentScan(basePackageClasses=HelloWorldController.class)
public class RestWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWebServicesApplication.class, args);
	}

}
