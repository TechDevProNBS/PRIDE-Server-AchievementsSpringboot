package com.nationwide.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nationwide.data.Achievements;
import com.nationwide.data.Criteria;
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
	
	public ArrayList<Achievements> getAllAchievements() {
		return arepo.findAll();
	}
	
	public String saveAchievement(String description, int points, int p, int r, int i, int d, int e, int a) {
		String returnString = "";
		Achievements ach = new Achievements(description, points);
		try {
			arepo.save(ach);
			returnString+="Achievement saved";
		}
		catch (Exception achievementexc) {
			System.out.println("Achievement exception:"+achievementexc);
		}
		int achievementid = arepo.findMaxAchievement_id();
		Criteria c = new Criteria(achievementid, p, r, i, d, e, a);
		try {
			crepo.save(c);
			returnString+="Criteria saved";
		}
		catch (Exception criteriaexc) {
			System.out.println("Criteria exception:"+criteriaexc);
		}
		return returnString;
	}
}
