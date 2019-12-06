package com.nationwide.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.data.EmpAchievements;
import com.nationwide.data.Progress;
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
	
	@GetMapping("/emp_achievements/{empno}/{p}/{r}/{i}/{d}/{e}")
	public ArrayList<Progress> saveAchievementsGetProgress(
			@PathVariable String empno,
			@PathVariable int p,
			@PathVariable int r,
			@PathVariable int i,
			@PathVariable int d,
			@PathVariable int e) {
		return service.saveAchievementsGetProgress(empno,p,r,i,d,e);		
	}
	
	@PostMapping("/emp_achievements/{empno}/{p}/{r}/{i}/{d}/{e}")
	public ArrayList<String> checkandsaveEmpAchievements(
			@PathVariable String empno,
			@PathVariable String p,
			@PathVariable String r,
			@PathVariable String i,
			@PathVariable String d,
			@PathVariable String e) {
		return service.checkandsaveEmpAchievement(empno,p,r,i,d,e);		
	}

}
