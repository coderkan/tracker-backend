package com.example.eko.ekoapi.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.eko.ekoapi.model.User;
import com.example.eko.ekoapi.repository.UserRepository;

@Controller
@RequestMapping("/demo")
public class MainController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		//userRepository.save(new User(name, email, password));
		
		if(userRepository.findByEmail(email) != null)
			return "e-mail already saved";
		else
			userRepository.save(new User(name, email, this.passwordEncoder.encode(password)));
		return "Saved";	
	}
	
	/*
	@GetMapping("/session")
	String uid(HttpSession session) {
		return session.getId();
	}
	*/
	
	@GetMapping(path="/login")
	public @ResponseBody String loginControl(@RequestParam String email, @RequestParam String password) {
		User user = userRepository.findByEmail(email);
		if(user == null)
			return "Not Found User";
		if(passwordEncoder.matches(password, user.getPassword())) {
			return "Session Created Successfully";
		}else 
			return "Password is not correct";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
	
}
