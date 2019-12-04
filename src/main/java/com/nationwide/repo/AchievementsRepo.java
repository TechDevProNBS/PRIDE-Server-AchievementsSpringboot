package com.nationwide.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nationwide.data.Achievements;

@Repository
public interface AchievementsRepo extends JpaRepository<Achievements, Integer> {
}