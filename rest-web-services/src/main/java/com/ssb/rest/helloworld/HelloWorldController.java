package com.ssb.rest.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	
	@RequestMapping(method = RequestMethod.GET,path = "/hw")
	public String hellWorld() {
		return "hello=world";
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/hwb")
	public HelloWorldBean hellWorldBean() {
		return new HelloWorldBean("hello bean world");
	}
	@RequestMapping(method = RequestMethod.GET,path = "/hwb/{name}")
	public HelloWorldBean hellWorldPathV(@PathVariable String name) {
		return new HelloWorldBean("hello bean world,"+name);
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/hwi")
	public String hellWorldInternalization() {
		
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message",null,"Default message", locale);
	}
	
}
