package com.onboarding.application.dao;

import java.util.List;
import com.onboarding.application.entity.EmployeeEntity;
import com.onboarding.application.request.EmployeeRequestPojo;

public interface OnboardingDao {

	// hibernate
	public void onboardingDraft(EmployeeEntity employeeEntity);

	public void updateValues(EmployeeRequestPojo employeeRequestPojo, EmployeeEntity employeeEntity);

	public List<Object> findAllByEmp();

	public List<Object> fetchById(EmployeeRequestPojo employeeRequestPojo);

	public List<Object> getById(EmployeeRequestPojo employeeRequestPojo);

	// jdbcTemplate
	int update(EmployeeRequestPojo employee);

	int updateBank(EmployeeRequestPojo employeeRequestPojo);

	int updateHobbies(EmployeeRequestPojo employeeRequestPojo, EmployeeEntity employeeEntity);

	EmployeeEntity findById(EmployeeRequestPojo employeeRequestPojo);

	List<EmployeeEntity> findAll();

	// saveMethods
	EmployeeRequestPojo saveEmployee(EmployeeRequestPojo employeeEntity);

	int saveBank(EmployeeRequestPojo employeeEntity, int key);

	int[] batchHobbies(EmployeeRequestPojo employeeRequestPojo, int key);

	public int[] batchSkill(EmployeeRequestPojo employeeRequestPojo, int key);

	public int[] batchPerviousEmp(EmployeeRequestPojo employeeRequestPojo, int key);

	public int[] batchFam(EmployeeRequestPojo employeeRequestPojo, int key);

	public int[] batchEducation(EmployeeRequestPojo employeeRequestPojo, int key);

	// Update
	int[] updateHobbiess(EmployeeRequestPojo employeeRequestPojo);

}
