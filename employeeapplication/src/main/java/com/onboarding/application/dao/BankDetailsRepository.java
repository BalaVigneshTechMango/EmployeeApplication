package com.onboarding.application.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onboarding.application.entity.BankDetailsEntity;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetailsEntity, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE BankDetailsEntity b SET b.bankName= :bankName where empid= :empid")
	public int updateStatus(@Param("empid") int empid, @Param("bankName") String bankName);
}
