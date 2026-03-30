package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class homecontroller {

	@GetMapping("/public")
	public String getpublicApi() {
		return "This is PUBLIC";
	}
	
	@GetMapping("/private")
	public String getprivateApi() {
		return "This is Private-API";
	}
	
}
