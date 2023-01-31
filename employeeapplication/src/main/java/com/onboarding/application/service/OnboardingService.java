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
	public EmployeeRequestPojo saveEmployee(EmployeeRequestPojo employeeRequestPojo);

	public int saveBank(EmployeeRequestPojo employeeRequestPojo, int key);

	public void batchHobbies(EmployeeRequestPojo employeeRequestPojo, int key);

	public void batchSkill(EmployeeRequestPojo employeeRequestPojo, int key);

	public void batchPerviousEmp(EmployeeRequestPojo employeeRequestPojo, int key);

	public void batchFam(EmployeeRequestPojo employeeRequestPojo, int key);

	public void batchEducation(EmployeeRequestPojo employeeRequestPojo, int key);

}
