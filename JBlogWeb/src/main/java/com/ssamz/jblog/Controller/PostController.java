package com.ssamz.jblog.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class PostController {
	@GetMapping({"","/"})
	public String getPost() {
		return "index";
	}
}
