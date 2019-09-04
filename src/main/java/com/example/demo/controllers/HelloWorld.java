package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.APIResponse;
import com.example.demo.models.AuthToken;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class HelloWorld {
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "Hello, world!";
	}
	@RequestMapping("/token/generate-token")
	@ResponseBody
	public APIResponse foo() {
		
		return new APIResponse(200,"success", new AuthToken("foobar"));
	}
}
