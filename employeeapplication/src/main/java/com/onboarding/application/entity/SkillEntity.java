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
@Table(name = "skill_set")
public class SkillEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private int skillId;
	@Column(name = "skills")
	private String skills;
	@Column(name = "level_of_skill")
	private String levelOfSkill;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = EmployeeEntity.class)
	@JoinColumn(name = "empid")
	private EmployeeEntity employeeEntity;

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getLevelOfSkill() {
		return levelOfSkill;
	}

	public void setLevelOfSkill(String levelOfSkill) {
		this.levelOfSkill = levelOfSkill;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}
}
