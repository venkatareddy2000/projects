package com.library.management.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class HomeController {
	@GetMapping("/home")
	public String homePage() {
		return "view/home/home-page";
	}

}
