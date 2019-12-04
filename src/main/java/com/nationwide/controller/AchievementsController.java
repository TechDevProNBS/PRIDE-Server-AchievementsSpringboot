package com.nationwide.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nationwide.service.AchievementsService;
import com.nationwide.data.Achievements;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AchievementsController {
	
	@Autowired
	private AchievementsService service;
	
	@GetMapping("/achievements")
	public List<Achievements> getAllAchievements(){
		return service.getAllAchievements();
	}

}
