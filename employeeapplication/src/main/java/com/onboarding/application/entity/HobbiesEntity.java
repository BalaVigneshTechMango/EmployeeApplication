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

@Entity
@Table(name = "hobbies_details")
public class HobbiesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hobbieId")
	private int hobbieId;
	@Column(name = "hobbies")
	private String hobbies;
	@Column(name = "hobbies_level")
	private String  hobbiesLevel;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = EmployeeEntity.class)
	@JoinColumn(name = "empid")
	private EmployeeEntity employeeEntity;

	public int getHobbieId() {
		return hobbieId;
	}

	public void setHobbieId(int hobbieId) {
		this.hobbieId = hobbieId;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getHobbiesLevel() {
		return hobbiesLevel;
	}

	public void setHobbiesLevel(String hobbiesLevel) {
		this.hobbiesLevel = hobbiesLevel;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}
	
}
