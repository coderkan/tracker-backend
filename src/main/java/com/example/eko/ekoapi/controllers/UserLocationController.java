package com.example.eko.ekoapi.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.eko.ekoapi.model.UserLocation;
import com.example.eko.ekoapi.repository.UserLocationRepository;


@Controller
@RequestMapping("/demo/location")
public class UserLocationController {

	@Autowired
	private UserLocationRepository userLocationRepository;
	
	@GetMapping(path="/addLocation") // Map ONLY GET Requests
	public @ResponseBody String addNewUser(
			@RequestParam Integer loc_user_id, 
			@RequestParam String loc_lat,
			@RequestParam String loc_lng
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		UserLocation n = new UserLocation();
		n.setLocationUserId(loc_user_id);
		n.setLocationLat(loc_lat);
		n.setLocationLng(loc_lng);
		n.setLocationSavedDate(new Date());
		userLocationRepository.save(n);
		return "Saved Location";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<UserLocation> getAllUsers(){
		// This returns a JSON or XML with the users
		return userLocationRepository.findAll();
	}
	
}
