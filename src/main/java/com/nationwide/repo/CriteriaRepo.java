package com.nationwide.repo;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CriteriaRepo extends JpaRepository<Criteria, Integer> {
	
	public ArrayList<Criteria> findAll();
}