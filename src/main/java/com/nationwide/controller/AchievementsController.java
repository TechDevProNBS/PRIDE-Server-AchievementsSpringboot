package com.nationwide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.service.AchievementsService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AchievementsController {
	
	@Autowired
	private AchievementsService service;

}
