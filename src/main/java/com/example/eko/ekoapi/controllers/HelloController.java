package com.example.eko.ekoapi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String sayHi() {
		return "Hi Erkan";
	}
	
	@GetMapping("/app/login")
	public String sayLogin(HttpServletRequest request) {
		return "Loginnn";
	}
	
	@GetMapping("/session")
	public String getSession(HttpSession httpSession) {
		return httpSession.getId();
	}
	
}
