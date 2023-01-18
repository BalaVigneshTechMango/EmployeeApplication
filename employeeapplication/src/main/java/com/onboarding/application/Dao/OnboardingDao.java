package com.onboarding.application.Dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onboarding.application.entity.EmployeeEntity;
import com.onboarding.application.request.EmployeeRequestPojo;
import com.onboarding.application.responce.ResponcePojo;


public interface OnboardingDao {

	public void onboardingDraft(EmployeeEntity employeeEntity);

	public void updateValues(EmployeeRequestPojo employeeRequestPojo,EmployeeEntity employeeEntity);

	public List<Object> findAllByEmp();

     public List<Object> fetchById(EmployeeRequestPojo employeeRequestPojo);

	public List<Object> getById(EmployeeRequestPojo employeeRequestPojo);
	
	
}
