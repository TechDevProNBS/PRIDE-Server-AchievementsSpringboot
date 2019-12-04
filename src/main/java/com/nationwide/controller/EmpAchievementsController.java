package com.nationwide.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.data.EmpAchievements;
import com.nationwide.service.EmpAchievementsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmpAchievementsController {
	
	@Autowired
	private EmpAchievementsService service;
	
	@GetMapping("/emp_achievements/all")
	public ArrayList<EmpAchievements> findAll(){
		return service.findAll();
	}

}
