package com.onesoft.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneSoftController {
	
	@GetMapping(value="/getStudent")
	public String getthis() {
		return "This is Student";
	}
	
	@GetMapping(value="/getTrainer")
	public String gettrainer() {
		return "This is Trainer";
	}
	@GetMapping(value="/getManager")
	public String getmanger() {
		return "This is Manager";
	}

}
