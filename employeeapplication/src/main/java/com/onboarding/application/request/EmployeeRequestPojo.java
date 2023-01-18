package com.onboarding.application.request;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import com.onboarding.application.entity.EducationEntity;
import com.onboarding.application.entity.FamilyDetailsEntity;
import com.onboarding.application.entity.HobbiesEntity;
import com.onboarding.application.entity.PreviousEmploymentEntity;
import com.onboarding.application.entity.SkillEntity;

public class EmployeeRequestPojo {

	 private int empid;
	 private String fullName;
	 private String fatherName;
	 private Date dateOfBirth;
	 private String maritalStatus;
	 private String spouseName;
	 private Date anniversaryDate;
	 private String panNumber;
	 private String aadharNo;
	 private String designation;
	 private String department;
	 private String employeeId;
	 private Date dojTts;
	 private String monthOfExp;
	 private String genderEmp;
	 private String drivinglicenseNo;
	 private Date licenseExpiryDate;
	 private String voterIdNo;
	 private String passportNo;
	 private Date passportExpiry;
	 private String nativePlace;
	 private String phoneNoOne;
	 private String phoneNoTwo;
	 private String bloodGroup;
	 private String personalEmail;
	 private String officalMail;
	 private String presentAddress;
	 private String permanentAddress;
	 private String status;
	 private String skypeId;
	 private String tempId;
	 
	 private String bankName;
	 private String branchName;
	 private String accountNumber;
	 private String ifscCode;
	 
	 private Set<EducationEntity>education;
	 private Set<FamilyDetailsEntity>familyDetails;
	 private Set<HobbiesEntity>hobbies;
	 private Set<PreviousEmploymentEntity>previousEmployment;
	 private Set<SkillEntity>skill;
	
	 
	 
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	public String getTempId() {
		return tempId;
	}
	public void setTempId(String tempId) {
		this.tempId = tempId;
	}
	public String getSkypeId() {
		return skypeId;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	public String getFullName() {
		return fullName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public String getSpouseName() {
		return spouseName;
	}
	public Date getAnniversaryDate() {
		return anniversaryDate;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public String getDesignation() {
		return designation;
	}
	public String getDepartment() {
		return department;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public Date getDojTts() {
		return dojTts;
	}
	public String getMonthOfExp() {
		return monthOfExp;
	}
	public String getGenderEmp() {
		return genderEmp;
	}
	public String getDrivinglicenseNo() {
		return drivinglicenseNo;
	}
	public Date getLicenseExpiryDate() {
		return licenseExpiryDate;
	}
	public String getVoterIdNo() {
		return voterIdNo;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public Date getPassportExpiry() {
		return passportExpiry;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public String getPhoneNoOne() {
		return phoneNoOne;
	}
	public String getPhoneNoTwo() {
		return phoneNoTwo;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public String getPersonalEmail() {
		return personalEmail;
	}
	public String getOfficalMail() {
		return officalMail;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public String getStatus() {
		return status;
	}
	
	public String getBankName() {
		return bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public Set<EducationEntity> getEducation() {
		return education;
	}
	public Set<FamilyDetailsEntity> getFamilyDetails() {
		return familyDetails;
	}
	public Set<HobbiesEntity> getHobbies() {
		return hobbies;
	}
	public Set<PreviousEmploymentEntity> getPreviousEmployment() {
		return previousEmployment;
	}
	public Set<SkillEntity> getSkill() {
		return skill;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	public void setAnniversaryDate(Date anniversaryDate) {
		this.anniversaryDate = anniversaryDate;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public void setDojTts(Date dojTts) {
		this.dojTts = dojTts;
	}
	public void setMonthOfExp(String monthOfExp) {
		this.monthOfExp = monthOfExp;
	}
	public void setGenderEmp(String genderEmp) {
		this.genderEmp = genderEmp;
	}
	public void setDrivinglicenseNo(String drivinglicenseNo) {
		this.drivinglicenseNo = drivinglicenseNo;
	}
	public void setLicenseExpiryDate(Date licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}
	public void setVoterIdNo(String voterIdNo) {
		this.voterIdNo = voterIdNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public void setPassportExpiry(Date passportExpiry) {
		this.passportExpiry = passportExpiry;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public void setPhoneNoOne(String phoneNoOne) {
		this.phoneNoOne = phoneNoOne;
	}
	public void setPhoneNoTwo(String phoneNoTwo) {
		this.phoneNoTwo = phoneNoTwo;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	public void setOfficalMail(String officalMail) {
		this.officalMail = officalMail;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public void setEducation(Set<EducationEntity> education) {
		this.education = education;
	}
	public void setFamilyDetails(Set<FamilyDetailsEntity> familyDetails) {
		this.familyDetails = familyDetails;
	}
	public void setHobbies(Set<HobbiesEntity> hobbies) {
		this.hobbies = hobbies;
	}
	public void setPreviousEmployment(Set<PreviousEmploymentEntity> previousEmployment) {
		this.previousEmployment = previousEmployment;
	}
	public void setSkill(Set<SkillEntity> skill) {
		this.skill = skill;
	}
	
	 
	 
	 
	 
	
	
}
