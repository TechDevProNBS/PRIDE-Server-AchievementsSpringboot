package com.nationwide.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}
