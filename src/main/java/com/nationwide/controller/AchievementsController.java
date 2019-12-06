package com.nationwide.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.data.Achievements;
import com.nationwide.service.AchievementsService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AchievementsController {
	
	@Autowired
	private AchievementsService service;
	
	@GetMapping("/achievements/all")
	public ArrayList<Achievements> getAllAchievements(){
		return service.getAllAchievements();
	}
	
	@PostMapping("/achievements/{description}/{points}/{p}/{r}/{i}/{d}/{e}/{a}")
	public String saveAchievement(
			@PathVariable String description,
			@PathVariable int points,
			@PathVariable int p,
			@PathVariable int r,
			@PathVariable int i,
			@PathVariable int d,
			@PathVariable int e,
			@PathVariable int a){
		return service.saveAchievement(description,points,p,r,i,d,e,a);
	}

}
