package com.nationwide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nationwide.repo.AchievementsRepo;
import com.nationwide.repo.CriteriaRepo;
import com.nationwide.repo.EmpAchievementsRepo;


@Component
public class AchievementsService {
	
	@Autowired
	private AchievementsRepo arepo;
	
	@Autowired
	private CriteriaRepo crepo;
	
	@Autowired
	private EmpAchievementsRepo erepo;
	

}
