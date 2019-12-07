package com.nationwide.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nationwide.data.Achievements;
import com.nationwide.data.Criteria;
import com.nationwide.data.EmpAchievements;
import com.nationwide.data.Progress;
import com.nationwide.repo.AchievementsRepo;
import com.nationwide.repo.CriteriaRepo;
import com.nationwide.repo.EmpAchievementsRepo;

@Component
public class EmpAchievementsService {
	
	@Autowired
	private AchievementsRepo arepo;
	
	@Autowired
	private CriteriaRepo crepo;
	
	@Autowired
	private EmpAchievementsRepo erepo;
	
	public ArrayList<EmpAchievements> findAll(){
		return erepo.findAll();
	}
	
	public ArrayList<EmpAchievements> latestEmpAchievements(){
		ArrayList<EmpAchievements> all= erepo.findAll();
		ArrayList<EmpAchievements> topfive = new ArrayList<EmpAchievements>();
		if(all.size()<5) {
			return all;
		}
		else{
			for(int i=0;i<=4;i++) {
				topfive.add(all.get(i));
			}
			return topfive;
		}
	}
	
	public ArrayList<Progress> saveAchievementsGetProgress(String empno,int p,int r,int i,int d,int e) {
		int pno = p;
		int rno = r;
		int ino = i;
		int dno = d;
		int eno = e;
		int ano = pno+rno+ino+dno+eno;
		ArrayList<String> checkachievement = new ArrayList<String>();
		ArrayList<Progress> allprogress = new ArrayList<Progress>();
		ArrayList<Achievements> allachievements=arepo.findAll();
		ArrayList<EmpAchievements> allsavedachievements=erepo.findAll();
		ArrayList<Criteria> allcriteria=crepo.findAll();
		for(int x=0;x<allachievements.size();x++) {
			checkachievement.add("start");
			for(int y=0;y<allsavedachievements.size();y++) {
				if(allsavedachievements.get(y).getRempno().contentEquals(empno) && allsavedachievements.get(y).getAchievement_id()==allachievements.get(x).getAchievement_id()){
					checkachievement.add(x,"complete");
					int progressachieved = 1;
					int progressbar = 1;
					int achievementno = allachievements.get(x).getAchievement_id();
					String achievementdesc = allachievements.get(x).getDescription();
					int points = allachievements.get(x).getPoints();
					int pointsachieved = allachievements.get(x).getPoints();
					Progress thisprogress = new Progress(progressbar,progressachieved,achievementno,achievementdesc,points,pointsachieved);
					allprogress.add(thisprogress);
				}
			}
			for(int z=0;z<allcriteria.size();z++) {
				if(!checkachievement.get(x).contentEquals("complete") && allachievements.get(x).getAchievement_id()==allcriteria.get(z).getAchievement_id()) {
					if(pno>=allcriteria.get(z).getP() && rno>=allcriteria.get(z).getR() && ino>=allcriteria.get(z).getI() && dno>=allcriteria.get(z).getD() && eno>=allcriteria.get(z).getE()) {
						if(ano>=(allcriteria.get(z).getA())){
							saveEmpAchievement(empno,allachievements.get(x).getAchievement_id());
							checkachievement.add(x,"complete");
							int progressachieved = 1;
							int progressbar = 1;
							int achievementno = allachievements.get(x).getAchievement_id();
							String achievementdesc = allachievements.get(x).getDescription();
							int points = allachievements.get(x).getPoints();
							int pointsachieved = allachievements.get(x).getPoints();
							Progress thisprogress = new Progress(progressbar, progressachieved,achievementno,achievementdesc,points,pointsachieved);
							allprogress.add(thisprogress);
						}
						else {
							int progressachieved= ano;
							int progressbar = allcriteria.get(z).getA();
							int achievementno = allachievements.get(x).getAchievement_id();
							String achievementdesc = allachievements.get(x).getDescription();
							int points = allachievements.get(x).getPoints();
							int pointsachieved = 0;
							Progress thisprogress = new Progress(progressbar,progressachieved,achievementno,achievementdesc,points,pointsachieved);
							allprogress.add(thisprogress);
							checkachievement.set(x, Integer.toString(progressbar));
						}
					}
					else {
						int pprogress = 0;
						int rprogress = 0;
						int iprogress = 0;
						int dprogress = 0;
						int eprogress = 0;
						int outof = 0;
						if(allcriteria.get(z).getP()>=1) {
							outof+=allcriteria.get(z).getP();
							if(pno>=allcriteria.get(z).getP()) {
								pprogress = allcriteria.get(z).getP();
							}
							else {
								pprogress = pno;
							}
						}
						if(allcriteria.get(z).getR()>=1) {
							outof+=allcriteria.get(z).getR();
							if(rno>=allcriteria.get(z).getR()) {
								rprogress = allcriteria.get(z).getR();
							}
							else {
								rprogress = rno;
							}
						}
						if(allcriteria.get(z).getI()>=1) {
							outof+=allcriteria.get(z).getI();
							if(ino>=allcriteria.get(z).getI()) {
								iprogress = allcriteria.get(z).getI();
							}
							else {
								iprogress = ino;
							}
						}
						if(allcriteria.get(z).getD()>=1) {
							outof+=allcriteria.get(z).getD();
							if(dno>=allcriteria.get(z).getD()) {
								dprogress = allcriteria.get(z).getD();
							}
							else {
								dprogress = dno;
							}
						}
						if(allcriteria.get(z).getE()>=1) {
							outof+=allcriteria.get(z).getE();
							if(eno>=allcriteria.get(z).getE()) {
								eprogress = allcriteria.get(z).getE();
							}
							else {
								eprogress = eno;
							}
						}
						int addedprogress = pprogress+rprogress+iprogress+dprogress+eprogress;
						int progressbar = outof;
						int achievementno = allachievements.get(x).getAchievement_id();
						String achievementdesc = allachievements.get(x).getDescription();
						int points = allachievements.get(x).getPoints();
						int pointsachieved = 0;
						Progress thisprogress = new Progress(progressbar,addedprogress,achievementno,achievementdesc,points,pointsachieved);
						allprogress.add(thisprogress);
						checkachievement.set(x, Integer.toString(progressbar));
					}
				}
			}
		}
		return allprogress;
	}
	
	public ArrayList<String> checkandsaveEmpAchievement(String empno,String p,String r,String i,String d,String e) {
		int pno = Integer.parseInt(p);
		int rno = Integer.parseInt(r);
		int ino = Integer.parseInt(i);
		int dno = Integer.parseInt(d);
		int eno = Integer.parseInt(e);
		int ano = pno+rno+ino+dno+eno;
		ArrayList<String> checkachievement = new ArrayList<String>();
		ArrayList<Achievements> allachievements=arepo.findAll();
		ArrayList<EmpAchievements> allsavedachievements=erepo.findAll();
		ArrayList<Criteria> allcriteria=crepo.findAll();
		for(int x=0;x<allachievements.size();x++) {
			checkachievement.add("start");
			for(int y=0;y<allsavedachievements.size();y++) {
				if(allsavedachievements.get(y).getRempno().contentEquals(empno) && allsavedachievements.get(y).getAchievement_id()==allachievements.get(x).getAchievement_id()){
					checkachievement.set(x, "already saved");
				}
			}
			for(int z=0;z<allcriteria.size();z++) {
				if(!checkachievement.get(x).contentEquals("complete") && allachievements.get(x).getAchievement_id()==allcriteria.get(z).getAchievement_id()) {
					if(pno>=allcriteria.get(z).getP() && rno>=allcriteria.get(z).getR() && ino>=allcriteria.get(z).getI() && dno>=allcriteria.get(z).getD() && eno>=allcriteria.get(z).getE()) {
						if(ano>=(allcriteria.get(z).getA())){
							saveEmpAchievement(empno,allachievements.get(x).getAchievement_id());
							checkachievement.set(x,"now saved");
						}
					}
				}
			}
		}
		return checkachievement;
	}
	
	public void saveEmpAchievement(String empno, int achievementId) {
		LocalDate date = LocalDate.now();
		EmpAchievements e = new EmpAchievements(empno, achievementId, Date.valueOf(date));
		erepo.save(e);
	}

}
