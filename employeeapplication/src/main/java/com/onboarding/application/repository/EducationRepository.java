package com.onboarding.application.repository;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onboarding.application.entity.EducationEntity;

@Repository
public interface EducationRepository extends JpaRepository<EducationEntity, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE EducationEntity q SET q.qualification= :qualification where empid= :empid")
	public int updateStatus(@Param("empid") int empid, @Param("qualification") Set<EducationEntity> set);
	
}
