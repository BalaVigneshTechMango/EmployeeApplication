package com.onboarding.application.repository;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onboarding.application.entity.HobbiesEntity;

@Repository
public interface HobbiesRepository extends JpaRepository<HobbiesEntity, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE HobbiesEntity h SET h.hobbies= :hobbies,h.hobbiesLevel= :hobbiesLevel where empid= :empid")
	public int updateStatus(int empid,Set<HobbiesEntity> hobbies);
	
}
