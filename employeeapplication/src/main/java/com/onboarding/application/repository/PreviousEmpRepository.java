package com.onboarding.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onboarding.application.entity.PreviousEmploymentEntity;

@Repository
public interface PreviousEmpRepository extends JpaRepository<PreviousEmploymentEntity, Integer>{

}
