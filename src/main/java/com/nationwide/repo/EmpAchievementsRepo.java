package com.nationwide.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nationwide.data.EmpAchievements;

public interface EmpAchievementsRepo extends JpaRepository<EmpAchievements, String> {
	
	public ArrayList<EmpAchievements> findAll();
}