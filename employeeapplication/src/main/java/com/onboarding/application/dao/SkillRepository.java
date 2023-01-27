package com.onboarding.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onboarding.application.entity.SkillEntity;
@Repository
public interface SkillRepository extends JpaRepository<SkillEntity,Integer>{

}
