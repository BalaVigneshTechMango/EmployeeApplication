package com.onboarding.application.service;

import java.util.List;

import com.onboarding.application.entity.EmployeeEntity;
import com.onboarding.application.request.EmployeeRequestPojo;
import com.onboarding.application.responce.ResponcePojo;

public interface OnboardingService {

	public void onboardingDraft(EmployeeRequestPojo employeeRequestPojo,EmployeeEntity employeeEntity);

	public void updateValues(EmployeeRequestPojo employeeRequestPojo,EmployeeEntity employeeEntity);

	public List<Object> findAllByEmp();

	public List<Object> fetchById(EmployeeRequestPojo employeeRequestPojo);

	public List<Object> getById(EmployeeRequestPojo employeeRequestPojo);

	
}
