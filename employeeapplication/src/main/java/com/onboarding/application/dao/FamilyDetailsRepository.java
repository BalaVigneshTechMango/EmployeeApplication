package com.onboarding.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onboarding.application.entity.FamilyDetailsEntity;

@Repository
public interface FamilyDetailsRepository extends JpaRepository<FamilyDetailsEntity, Integer> {

}
