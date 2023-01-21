package com.healthcare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	public Controller() {
		System.out.println("Controller.Controller()");
	}

	@GetMapping("/show")
	public String home() {
		System.out.println("Controller.home()");
		return "HomePage";
	}

}
