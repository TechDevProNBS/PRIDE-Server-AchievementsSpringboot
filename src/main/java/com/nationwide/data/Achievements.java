package com.nationwide.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "achievements")
public class Achievements {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int achievement_id;
	private String description;
	private int points;
	
	public Achievements() {
	}

	public Achievements(int achievement_id, String description, int points) {
		this.achievement_id = achievement_id;
		this.description = description;
		this.points = points;
	}

	public int getAchievement_id() {
		return achievement_id;
	}

	public void setAchievement_id(int achievement_id) {
		this.achievement_id = achievement_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}	

}
