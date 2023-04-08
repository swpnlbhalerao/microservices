package com.ssb.rest.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {

	
	private String message;
	private LocalDateTime timeStamp;
	private String details;
	public ErrorDetails(String message, LocalDateTime timeStamp, String details) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
		this.details = details;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}
