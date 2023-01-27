package com.onboarding.application.entity;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "previous_employment_details")
public class PreviousEmploymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pr_details_id")
	private int prEmpDetailsId;
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "pr_doj")
	private String prDoj;
	@Column(name = "pr_dor")
	private String prDor;
	@Column(name = "ctc_doj")
	private String ctcDoj;
	@Column(name = "ctc_dor")
	private String ctcDor;
	@Column(name = "role_doj")
	private String roleDoj;
	@Column(name = "role_dor")
	private String roleDor;
	@Column(name = "esi_dispensary_name")
	private String esiDespensaryName;
	@Column(name = "pervious_emp_no")
	private String perviousEmpNo;
	@Column(name = "pervious_insurance_no")
	private String perviousInsuranceNo;
	
	@JsonBackReference("empid")			
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = EmployeeEntity.class)
	@JoinColumn(name = "empid")
	private EmployeeEntity employeeEntity;

	public int getPrEmpDetailsId() {
		return prEmpDetailsId;
	}

	public void setPrEmpDetailsId(int prEmpDetailsId) {
		this.prEmpDetailsId = prEmpDetailsId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPrDoj() {
		return prDoj;
	}

	public void setPrDoj(String prDoj) {
		this.prDoj = prDoj;
	}

	public String getPrDor() {
		return prDor;
	}

	public void setPrDor(String prDor) {
		this.prDor = prDor;
	}

	public String getCtcDoj() {
		return ctcDoj;
	}

	public void setCtcDoj(String ctcDoj) {
		this.ctcDoj = ctcDoj;
	}

	public String getCtcDor() {
		return ctcDor;
	}

	public void setCtcDor(String ctcDor) {
		this.ctcDor = ctcDor;
	}

	public String getRoleDoj() {
		return roleDoj;
	}

	public void setRoleDoj(String roleDoj) {
		this.roleDoj = roleDoj;
	}

	public String getRoleDor() {
		return roleDor;
	}

	public void setRoleDor(String roleDor) {
		this.roleDor = roleDor;
	}

	public String getEsiDespensaryName() {
		return esiDespensaryName;
	}

	public void setEsiDespensaryName(String esiDespensaryName) {
		this.esiDespensaryName = esiDespensaryName;
	}

	public String getPerviousEmpNo() {
		return perviousEmpNo;
	}

	public void setPerviousEmpNo(String perviousEmpNo) {
		this.perviousEmpNo = perviousEmpNo;
	}

	public String getPerviousInsuranceNo() {
		return perviousInsuranceNo;
	}

	public void setPerviousInsuranceNo(String perviousInsuranceNo) {
		this.perviousInsuranceNo = perviousInsuranceNo;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}
	
	
}
