package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("country")
public class Demo {
	
	@GetMapping("ello")
	public String home() {
		return "ello";
	}

}
