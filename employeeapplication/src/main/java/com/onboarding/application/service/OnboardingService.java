package com.onboarding.application.service;

import java.util.List;

import com.onboarding.application.entity.EmployeeEntity;
import com.onboarding.application.request.EmployeeRequestPojo;
import com.onboarding.application.responce.ResponcePojo;

public interface OnboardingService {

	public void onboardingDraft(EmployeeRequestPojo employeeRequestPojo, EmployeeEntity employeeEntity);

	public void updateValues(EmployeeRequestPojo employeeRequestPojo, EmployeeEntity employeeEntity);

	public List<Object> findAllByEmp();

	public List<Object> fetchById(EmployeeRequestPojo employeeRequestPojo);

	public List<Object> getById(EmployeeRequestPojo employeeRequestPojo);

	public void draftUpate(EmployeeRequestPojo employeeRequestPojo, EmployeeEntity employeeEntity,
			EmployeeEntity employee);

	// JdbcTemplate

	// SaveMethods
	public int saveEmployee(EmployeeRequestPojo employeeRequestPojo);

	public int saveBank(EmployeeRequestPojo employeeRequestPojo,int a);

	public void batchHobbies(EmployeeRequestPojo employeeRequestPojo);

	public void batchSkill(EmployeeRequestPojo employeeRequestPojo);

	public void batchPerviousEmp(EmployeeRequestPojo employeeRequestPojo);

	public void batchFam(EmployeeRequestPojo employeeRequestPojo);

	public void batchEducation(EmployeeRequestPojo employeeRequestPojo);

}
