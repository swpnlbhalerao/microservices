package com.example.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversiomController {

	@Autowired
	CurrencyExchangeProxy currencyExchangeProxy;
	
	@GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calcCurrencyConversion(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		HashMap<String,String> uriVar = new HashMap<>();
		uriVar.put("from", from);
		uriVar.put("to", to);
		
		ResponseEntity<CurrencyConversion> resp=new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}", 
				CurrencyConversion.class,uriVar);
				
		CurrencyConversion currencyConversion = resp.getBody();
		
		return new CurrencyConversion(currencyConversion.getId(), from,to,currencyConversion.getConversionMultiple(),quantity, quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment()+ "rest template");
		
	}
	
	@GetMapping(path = "/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calcCurrencyConversionFeign(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity) {
		
	
		CurrencyConversion currencyConversion = currencyExchangeProxy.retriveExchange(from, to);
		
		return new CurrencyConversion(currencyConversion.getId(), from,to,currencyConversion.getConversionMultiple(),quantity, quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment()+" feign");
		
	}
	
}
