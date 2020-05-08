package com.tracklink.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiplicationController {
	
	@GetMapping(value="/{num1}/{num2}", produces = "text/plain")
	public String multiply(@PathVariable("num1") Integer num1,@PathVariable("num2") Integer num2) {
		return String.format("%d x %d = %d", num1, num2 , (num1 * num2));
	}
	
	
	
	
}
