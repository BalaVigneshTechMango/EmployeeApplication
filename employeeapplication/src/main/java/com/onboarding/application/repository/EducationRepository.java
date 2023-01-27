package com.onboarding.application.repository;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onboarding.application.entity.EducationEntity;
import com.onboarding.application.entity.EmployeeEntity;

@Repository
public interface EducationRepository extends JpaRepository<EducationEntity, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE EducationEntity q SET q.qualification= :qualification where qId= :qId")
	public int updateStatus(@Param("qId") int qId, @Param("qualification") Set<EducationEntity> set);

	public void save(Optional<EducationEntity> educationEntity);

	
	
}
