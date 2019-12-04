package com.nationwide.data;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_achievements")
public class EmpAchievements {
	
	@Id
	private String rempno;
	private int achievement_id;
	private Date date_achieved;
	
	public EmpAchievements() {
	}

	public EmpAchievements(String rempno, int achievement_id, Date date_achieved) {
		this.rempno = rempno;
		this.achievement_id = achievement_id;
		this.date_achieved = date_achieved;
	}

	public String getRempno() {
		return rempno;
	}

	public void setRempno(String rempno) {
		this.rempno = rempno;
	}

	public int getAchievement_id() {
		return achievement_id;
	}

	public void setAchievement_id(int achievement_id) {
		this.achievement_id = achievement_id;
	}

	public Date getDate_achieved() {
		return date_achieved;
	}

	public void setDate_achieved(Date date_achieved) {
		this.date_achieved = date_achieved;
	}
	
}