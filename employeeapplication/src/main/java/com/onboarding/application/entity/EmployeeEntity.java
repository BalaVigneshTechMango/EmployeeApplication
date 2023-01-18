package com.onboarding.application.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empid")
	private int empid;
	@Column(name = "fullName")
	private String fullName;
	@Column(name = "fatherName")
	private String fatherName;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	@Column(name = "marital_status")
	private String maritalStatus;
	@Column(name = "spouse_name")
	private String spouseName;
	@Column(name = "anniversary_date")
	private Date anniversaryDate;
	@Column(name = "pan_number")
	private String panNumber;
	@Column(name = "aadhaar_no")
	private String aadhaarNo;
	@Column(name = "designation")
	private String designation;
	@Column(name = "department")
	private String department;
	@Column(name = "employee_id")
	private String employeeId;
	@Column(name = "doj_tts")
	private Date dojTts;
	@Column(name = "month_of_exp")
	private String monthOfExp;
	@Column(name = "gender_emp")
	private String genderEmp;
	@Column(name = "driving_license_no")
	private String drivinglicenseNo;
	@Column(name = "license_expiry_date")
	private Date licenseExpiryDate;
	@Column(name = "voter_id_no")
	private String voterIdNo;
	@Column(name = "passport_no")
	private String passportNo;
	@Column(name = "passport_expiry")
	private Date passportExpiry;
	@Column(name = "native_place")
	private String nativePlace;
	@Column(name = "ph_one")
	private String phoneNoOne;
	@Column(name = "ph_two")
	private String phoneNoTwo;
	@Column(name = "blood_group")
	private String bloodGroup;
	@Column(name = "personal_email")
	private String personalEmail;
	@Column(name = "offical_mail")
	private String officalMail;
	@Column(name = "present_address")
	private String presentAddress;
	@Column(name = "permanent_address")
	private String permanentAddress;
	@Column(name = "status")
	private String status;
	@Column(name = "skype_id")
	private String skypeId;
	@Column(name = "temp_id")
	private String  tempId;
	
    
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employeeEntity",fetch = FetchType.EAGER)
	private BankDetailsEntity bankDetailsEntity;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, targetEntity = FamilyDetailsEntity.class)
	@JoinColumn(name = "empid",referencedColumnName = "empid")
	private Set<FamilyDetailsEntity> familyDetailsEntities = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, targetEntity = EducationEntity.class)
	@JoinColumn(name = "empid",referencedColumnName = "empid")
	private Set<EducationEntity> educationEntity = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, targetEntity = HobbiesEntity.class)
	@JoinColumn(name = "empid",referencedColumnName = "empid")
	private Set<HobbiesEntity> hobbiesEntities = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = PreviousEmploymentEntity.class)
	@JoinColumn(name = "empid",referencedColumnName = "empid")
	private Set<PreviousEmploymentEntity> previousEmploymentEntities = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = SkillEntity.class)
	@JoinColumn(name = "empid",referencedColumnName = "empid")
	private Set<SkillEntity> skillEntities = new HashSet<>();

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getSkypeId() {
		return skypeId;
	}



	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public Date getAnniversaryDate() {
		return anniversaryDate;
	}

	public void setAnniversaryDate(Date anniversaryDate) {
		this.anniversaryDate = anniversaryDate;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDojTts() {
		return dojTts;
	}

	public void setDojTts(Date dojTts) {
		this.dojTts = dojTts;
	}

	public String getMonthOfExp() {
		return monthOfExp;
	}

	public void setMonthOfExp(String monthOfExp) {
		this.monthOfExp = monthOfExp;
	}

	public String getGenderEmp() {
		return genderEmp;
	}

	public void setGenderEmp(String genderEmp) {
		this.genderEmp = genderEmp;
	}

	public String getDrivinglicenseNo() {
		return drivinglicenseNo;
	}

	public void setDrivinglicenseNo(String drivinglicenseNo) {
		this.drivinglicenseNo = drivinglicenseNo;
	}

	public Date getLicenseExpiryDate() {
		return licenseExpiryDate;
	}

	public void setLicenseExpiryDate(Date licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}

	public String getVoterIdNo() {
		return voterIdNo;
	}

	public void setVoterIdNo(String voterIdNo) {
		this.voterIdNo = voterIdNo;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public Date getPassportExpiry() {
		return passportExpiry;
	}

	public void setPassportExpiry(Date passportExpiry) {
		this.passportExpiry = passportExpiry;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getPhoneNoOne() {
		return phoneNoOne;
	}

	public void setPhoneNoOne(String phoneNoOne) {
		this.phoneNoOne = phoneNoOne;
	}

	public String getPhoneNoTwo() {
		return phoneNoTwo;
	}

	public void setPhoneNoTwo(String phoneNoTwo) {
		this.phoneNoTwo = phoneNoTwo;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getOfficalMail() {
		return officalMail;
	}

	public void setOfficalMail(String officalMail) {
		this.officalMail = officalMail;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BankDetailsEntity getBankDetailsEntity() {
		return bankDetailsEntity;
	}

	public void setBankDetailsEntity(BankDetailsEntity bankDetailsEntity) {
		this.bankDetailsEntity = bankDetailsEntity;
	}

	public Set<FamilyDetailsEntity> getFamilyDetailsEntities() {
		return familyDetailsEntities;
	}

	public void setFamilyDetailsEntities(Set<FamilyDetailsEntity> familyDetailsEntities) {
		this.familyDetailsEntities = familyDetailsEntities;
	}

	public Set<EducationEntity> getEducationEntity() {
		return educationEntity;
	}

	public void setEducationEntity(Set<EducationEntity> educationEntity) {
		this.educationEntity = educationEntity;
	}

	public Set<HobbiesEntity> getHobbiesEntities() {
		return hobbiesEntities;
	}

	public void setHobbiesEntities(Set<HobbiesEntity> hobbiesEntities) {
		this.hobbiesEntities = hobbiesEntities;
	}

	public Set<PreviousEmploymentEntity> getPreviousEmploymentEntities() {
		return previousEmploymentEntities;
	}

	public void setPreviousEmploymentEntities(Set<PreviousEmploymentEntity> previousEmploymentEntities) {
		this.previousEmploymentEntities = previousEmploymentEntities;
	}

	public Set<SkillEntity> getSkillEntities() {
		return skillEntities;
	}

	public void setSkillEntities(Set<SkillEntity> skillEntities) {
		this.skillEntities = skillEntities;
	}

}
