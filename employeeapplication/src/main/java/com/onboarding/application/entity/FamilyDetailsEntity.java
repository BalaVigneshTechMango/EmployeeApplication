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
@Table(name = "family_details")
public class FamilyDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "family_id")
	private int familyId;
	@Column(name = "fam_full_name")
	private String famFullName;
	@Column(name = "members_dob")
	private Date membersDob;
	@Column(name = "relationship")
	private String relationShip;
	@Column(name = "is_emergency")
	private boolean isEmergency;
	@Column(name = "is_family_members")
	private boolean isFamilyMembers;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = EmployeeEntity.class)
	@JoinColumn(name = "empid")
	private EmployeeEntity employeeEntity;

	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	public String getFamFullName() {
		return famFullName;
	}

	public void setFamFullName(String famFullName) {
		this.famFullName = famFullName;
	}

	public Date getMembersDob() {
		return membersDob;
	}

	public void setMembersDob(Date membersDob) {
		this.membersDob = membersDob;
	}

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public boolean isEmergency() {
		return isEmergency;
	}

	public void setEmergency(boolean isEmergency) {
		this.isEmergency = isEmergency;
	}

	public boolean isFamilyMembers() {
		return isFamilyMembers;
	}

	public void setFamilyMembers(boolean isFamilyMembers) {
		this.isFamilyMembers = isFamilyMembers;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}
	
}
