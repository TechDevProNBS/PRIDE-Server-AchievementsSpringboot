package com.nationwide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nationwide.data.Achievements;
import com.nationwide.repo.AchievementsRepo;

@Component
public class AchievementsService {

	@Autowired
	private AchievementsRepo arepo;

	public List<Achievements> getAllAchievements() {
		return arepo.findAll();
	}

}
