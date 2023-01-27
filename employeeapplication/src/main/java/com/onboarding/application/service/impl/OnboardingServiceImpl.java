package com.onboarding.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onboarding.application.dao.OnboardingDao;
import com.onboarding.application.entity.BankDetailsEntity;
import com.onboarding.application.entity.EmployeeEntity;
import com.onboarding.application.entity.HobbiesEntity;
import com.onboarding.application.repository.EmployeeDetailsRepository;
import com.onboarding.application.request.EmployeeRequestPojo;
import com.onboarding.application.responce.ResponcePojo;
import com.onboarding.application.service.OnboardingService;

@Service
public class OnboardingServiceImpl implements OnboardingService {
	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	@Autowired
	private OnboardingDao onboardingDao;

	public void onboardingDraft(EmployeeRequestPojo employeeRequestPojo, EmployeeEntity employeeEntity) {

		BankDetailsEntity bankDetailsEntity = new BankDetailsEntity();
		employeeEntity.setEmpid(employeeRequestPojo.getEmpid());
		employeeEntity.setFullName(employeeRequestPojo.getFullName());
		employeeEntity.setFatherName(employeeRequestPojo.getFatherName());
		employeeEntity.setDateOfBirth(employeeRequestPojo.getDateOfBirth());
		employeeEntity.setMaritalStatus(employeeRequestPojo.getMaritalStatus());
		employeeEntity.setSpouseName(employeeRequestPojo.getSpouseName());
		employeeEntity.setAnniversaryDate(employeeRequestPojo.getAnniversaryDate());
		employeeEntity.setPanNumber(employeeRequestPojo.getPanNumber());
		employeeEntity.setAadhaarNo(employeeRequestPojo.getAadharNo());
		employeeEntity.setDesignation(employeeRequestPojo.getDesignation());
		employeeEntity.setDepartment(employeeRequestPojo.getDepartment());
		employeeEntity.setEmployeeId(employeeRequestPojo.getEmployeeId());
		employeeEntity.setDojTts(employeeRequestPojo.getDojTts());
		employeeEntity.setMonthOfExp(employeeRequestPojo.getMonthOfExp());
		employeeEntity.setGenderEmp(employeeRequestPojo.getGenderEmp());
		employeeEntity.setDrivinglicenseNo(employeeRequestPojo.getDrivinglicenseNo());
		employeeEntity.setLicenseExpiryDate(employeeRequestPojo.getLicenseExpiryDate());
		employeeEntity.setVoterIdNo(employeeRequestPojo.getVoterIdNo());
		employeeEntity.setPassportNo(employeeRequestPojo.getPassportNo());
		employeeEntity.setPassportExpiry(employeeRequestPojo.getPassportExpiry());
		employeeEntity.setNativePlace(employeeRequestPojo.getNativePlace());
		employeeEntity.setPhoneNoOne(employeeRequestPojo.getPhoneNoOne());
		employeeEntity.setPhoneNoTwo(employeeRequestPojo.getPhoneNoTwo());
		employeeEntity.setPersonalEmail(employeeRequestPojo.getPersonalEmail());
		employeeEntity.setPermanentAddress(employeeRequestPojo.getPermanentAddress());
		employeeEntity.setOfficalMail(employeeRequestPojo.getOfficalMail());
		employeeEntity.setPresentAddress(employeeRequestPojo.getPresentAddress());
		employeeEntity.setBloodGroup(employeeRequestPojo.getBloodGroup());
		employeeEntity.setSkypeId(employeeRequestPojo.getSkypeId());

		bankDetailsEntity.setBankName(employeeRequestPojo.getBankName());
		bankDetailsEntity.setBranchName(employeeRequestPojo.getBranchName());
		bankDetailsEntity.setAccountNumber(employeeRequestPojo.getAccountNumber());
		bankDetailsEntity.setIfscCode(employeeRequestPojo.getIfscCode());
		bankDetailsEntity.setEmployeeEntity(employeeEntity);
		employeeEntity.setBankDetailsEntity(bankDetailsEntity);

		employeeEntity.setEducationEntity(employeeRequestPojo.getEducation());
		employeeEntity.setFamilyDetailsEntities(employeeRequestPojo.getFamilyDetails());
		employeeEntity.setHobbiesEntities(employeeRequestPojo.getHobbies());
		employeeEntity.setPreviousEmploymentEntities(employeeRequestPojo.getPreviousEmployment());
		employeeEntity.setSkillEntities(employeeRequestPojo.getSkill());

		HobbiesEntity hobbiesEntity = new HobbiesEntity();

		onboardingDao.onboardingDraft(employeeEntity);

//	  employeeRepository.save(employeeEntity);
//	  employeeRepository.saveBank(employeeEntity);
//	  employeeRepository.saveHobbies(employeeEntity);

	}

	public void updateValues(EmployeeRequestPojo employeeRequestPojo, EmployeeEntity employeeEntity) {

		onboardingDao.updateValues(employeeRequestPojo, employeeEntity);

	}

	public List<Object> findAllByEmp() {
		return onboardingDao.findAllByEmp();
	}

	public List<Object> fetchById(EmployeeRequestPojo employeeRequestPojo) {
		return onboardingDao.fetchById(employeeRequestPojo);
	}

	public List<Object> getById(EmployeeRequestPojo employeeRequestPojo) {
		return onboardingDao.getById(employeeRequestPojo);
	}

//	@Override
//	public void draftUpate(EmployeeRequestPojo employeeRequestPojo, EmployeeEntity employeeEntity) {
//		employee.setFullName(employeeRequestPojo.getFullName());
//		employee.setEducationEntity(employeeRequestPojo.getEducation());
//		employee.setFamilyDetailsEntities(employeeRequestPojo.getFamilyDetails());
//		employee.setSkillEntities(employeeRequestPojo.getSkill());
//		employee.setHobbiesEntities(employeeRequestPojo.getHobbies());
//		employee.setPreviousEmploymentEntities(employeeRequestPojo.getPreviousEmployment());
//		employeeDetailsRepository.save(employee);
//	}

	@Override
	public void draftUpate(EmployeeRequestPojo employeeRequestPojo, EmployeeEntity employeeEntity,
			EmployeeEntity employee) {
		employee.setFullName(employeeRequestPojo.getFullName());
		employee.setEducationEntity(employeeRequestPojo.getEducation());
		employee.setFamilyDetailsEntities(employeeRequestPojo.getFamilyDetails());
		employee.setSkillEntities(employeeRequestPojo.getSkill());
		employee.setHobbiesEntities(employeeRequestPojo.getHobbies());
		employee.setPreviousEmploymentEntities(employeeRequestPojo.getPreviousEmployment());
		employeeDetailsRepository.save(employee);
	}

	// JdbcTemplate

	// Save methods
	@Override
	public void batchHobbies(EmployeeRequestPojo employeeRequestPojo) {
		onboardingDao.batchHobbies(employeeRequestPojo);
	}

	@Override
	public void batchSkill(EmployeeRequestPojo employeeRequestPojo) {
		onboardingDao.batchSkill(employeeRequestPojo);

	}

	@Override
	public void batchPerviousEmp(EmployeeRequestPojo employeeRequestPojo) {
		onboardingDao.batchPerviousEmp(employeeRequestPojo);

	}

	@Override
	public void batchFam(EmployeeRequestPojo employeeRequestPojo) {
		onboardingDao.batchFam(employeeRequestPojo);

	}

	@Override
	public void batchEducation(EmployeeRequestPojo employeeRequestPojo) {
		onboardingDao.batchEducation(employeeRequestPojo);

	}

	@Override
	public int saveEmployee(EmployeeRequestPojo employeeRequestPojo) {
		 return onboardingDao.saveEmployee(employeeRequestPojo);
         
	}

	@Override
	public int saveBank(EmployeeRequestPojo employeeRequestPojo,int a) {
		return onboardingDao.saveBank(employeeRequestPojo,a);
		

	}

}
