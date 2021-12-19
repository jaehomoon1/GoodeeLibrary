package com.min.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value = "/home.do")
	public String Home() {
		
		return "home";
	}
	
	@GetMapping(value = "/color.do")
	public String color() {
		return "book/color";
	}
}
