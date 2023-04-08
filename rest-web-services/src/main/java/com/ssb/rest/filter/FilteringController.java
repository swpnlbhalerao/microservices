package com.ssb.rest.filter;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {


	@GetMapping(path = "/filter1")
	public MappingJacksonValue getBean() {
		SomeBean bean = new SomeBean("fieldValue1","fieldValue2","fieldValue3");

		MappingJacksonValue jacksonValue = new MappingJacksonValue(bean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeFilterBean", filter);
		jacksonValue.setFilters(filters);
		return jacksonValue;
	}


	//dyanmic filtering
	@GetMapping(path = "/filterd")
	public SomeBean getBean1() {
		return new SomeBean("fieldValue1","fieldValue2","fieldValue3");
	}

}
