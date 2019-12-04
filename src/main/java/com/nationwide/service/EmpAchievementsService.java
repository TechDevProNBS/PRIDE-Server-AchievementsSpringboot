package com.nationwide.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nationwide.data.Achievements;
import com.nationwide.data.Criteria;
import com.nationwide.data.EmpAchievements;
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
	
	public ArrayList<String> checkEmpAchievement(String empno,String p,String r,String i,String d,String e) {
		int pno = Integer.parseInt(p);
		int rno = Integer.parseInt(r);
		int ino = Integer.parseInt(i);
		int dno = Integer.parseInt(d);
		int eno = Integer.parseInt(e);
		int ano = pno+rno+ino+dno+eno;
		ArrayList<String> progress = new ArrayList<String>();
		ArrayList<Achievements> alla=arepo.findAll();
		ArrayList<EmpAchievements> alle=erepo.findAll();
		ArrayList<Criteria> allc=crepo.findAll();
		for(int x=0;x<alla.size();x++) {
			progress.add("start");
			for(int y=0;y<alle.size();y++) {
				if(alle.get(y).getRempno().contentEquals(empno) && alle.get(y).getAchievement_id()==alla.get(x).getAchievement_id()){
					progress.set(x,"1/1");
				}
			}
			for(int z=0;z<allc.size();z++) {
				if(!progress.get(x).contentEquals("complete") && alla.get(x).getAchievement_id()==allc.get(z).getAchievement_id()) {
					if(pno>=allc.get(z).getP() && rno>=allc.get(z).getR() && ino>=allc.get(z).getI() && dno>=allc.get(z).getD() && eno>=allc.get(z).getE()) {
						if(ano>=(allc.get(z).getA())){
							saveEmpAchievement(empno,alla.get(x).getAchievement_id());
							progress.set(x, "1/1");
						}
						else {
							String allcompare = ano+"/"+allc.get(z).getA();
							progress.set(x, allcompare);
						}
					}
					else {
						int pprogress = 0;
						int rprogress = 0;
						int iprogress = 0;
						int dprogress = 0;
						int eprogress = 0;
						int outof = 0;
						if(allc.get(z).getP()>=1) {
							outof+=allc.get(z).getP();
							if(pno>=allc.get(z).getP()) {
								pprogress = allc.get(z).getP();
							}
							else {
								pprogress = pno;
							}
						}
						if(allc.get(z).getR()>=1) {
							outof+=allc.get(z).getR();
							if(rno>=allc.get(z).getR()) {
								rprogress = allc.get(z).getR();
							}
							else {
								rprogress = rno;
							}
						}
						if(allc.get(z).getI()>=1) {
							outof+=allc.get(z).getI();
							if(ino>=allc.get(z).getI()) {
								iprogress = allc.get(z).getI();
							}
							else {
								iprogress = ino;
							}
						}
						if(allc.get(z).getD()>=1) {
							outof+=allc.get(z).getD();
							if(dno>=allc.get(z).getD()) {
								dprogress = allc.get(z).getD();
							}
							else {
								dprogress = dno;
							}
						}
						if(allc.get(z).getE()>=1) {
							outof+=allc.get(z).getE();
							if(eno>=allc.get(z).getE()) {
								eprogress = allc.get(z).getE();
							}
							else {
								eprogress = eno;
							}
						}
						int addedprogress = pprogress+rprogress+iprogress+dprogress+eprogress;
						String lettercompare = addedprogress+"/"+outof;
						progress.set(x, lettercompare);
					}
				}
			}
		}
		return progress;
	}
	
	public void saveEmpAchievement(String empno, int achievementId) {
		LocalDate date = LocalDate.now();
		EmpAchievements e = new EmpAchievements(empno, achievementId, Date.valueOf(date));
		erepo.save(e);
	}

}
