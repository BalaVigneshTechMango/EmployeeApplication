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
	int saveEmployee(EmployeeRequestPojo employeeEntity);

	int saveBank(EmployeeRequestPojo employeeEntity,int a);

	int[] batchHobbies(EmployeeRequestPojo employeeRequestPojo);

	public int[] batchSkill(EmployeeRequestPojo employeeRequestPojo);

	public int[] batchPerviousEmp(EmployeeRequestPojo employeeRequestPojo);

	public int[] batchFam(EmployeeRequestPojo employeeRequestPojo);

	public int[] batchEducation(EmployeeRequestPojo employeeRequestPojo);

}
