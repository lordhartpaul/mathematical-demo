package com.sample.mathematicaldemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.mathematicaldemo.service.mathematicalService;

@RestController
public class mathematicalController {
	
	@Autowired 
	mathematicalService mathService;

	@RequestMapping(value="/calculation/{operand1}/{operand2}/{operation}", method = RequestMethod.POST)
	public double calculateResult(@PathVariable(name ="operand1", required = true) int operand1, @PathVariable(name ="operand2", required = false) int operand2, 
			@PathVariable(name ="operation", required = true) String operation) {
		
		float resultValue = mathService.getResult(operand1, operand2, operation);
		return resultValue;
	}
	
	
}
