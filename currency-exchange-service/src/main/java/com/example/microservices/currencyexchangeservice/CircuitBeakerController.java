package com.example.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBeakerController {

	Logger logger = LoggerFactory.getLogger(CircuitBeakerController.class);
	
	@GetMapping(path = "sample-api")
	//@Retry(name = "sample-api",fallbackMethod = "hardCodedResponse")
	//@CircuitBreaker(name = "sample-api",fallbackMethod = "hardCodedResponse")
	//@RateLimiter(name = "default")
	@Bulkhead(name = "default")
	public String sampleAPi() {
		logger.info("Simple API call recived");
		/*
		 * ResponseEntity<String> resp = new
		 * RestTemplate().getForEntity("http://localhost:8080", String.class); return
		 * resp.getBody();
		 */
		return "Sample-response";
	}
	
	public String hardCodedResponse(Exception e) {
		return "hardCoded-Response";
	}
}
