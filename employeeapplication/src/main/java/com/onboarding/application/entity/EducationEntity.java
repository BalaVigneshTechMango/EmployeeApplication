package com.onboarding.application.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "qualification_details")
public class EducationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "q_id")
	private int qId;
	@Column(name = "qualification")
	private String qualification;
	@Column(name = "major_Stream")
	private String majorStream;
	@Column(name = "institute_name")
	private String instituteName;
	@Column(name = "year_of_joining")
	private Date yearOfJoining;
	@Column(name = "year_of_passing")
	private Date yearOfPassing;
	@Column(name = "education_type")
	private String educationType;
	@Column(name = "percentage")
	private String percentage;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,targetEntity = EmployeeEntity.class)
	@JoinColumn(name = "empid")
	private EmployeeEntity employeeEntity;

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getMajorStream() {
		return majorStream;
	}

	public void setMajorStream(String majorStream) {
		this.majorStream = majorStream;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public Date getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(Date yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public Date getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(Date yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public String getEducationType() {
		return educationType;
	}

	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}
	
}
