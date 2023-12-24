package com.ssamz.jblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	@GetMapping("/home")
	public String goHome() {
		return "home";
	}
}
