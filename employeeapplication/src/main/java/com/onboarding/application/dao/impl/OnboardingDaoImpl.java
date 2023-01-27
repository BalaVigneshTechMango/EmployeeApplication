package com.onboarding.application.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.onboarding.application.dao.OnboardingDao;
import com.onboarding.application.entity.EducationEntity;
import com.onboarding.application.entity.EmployeeEntity;
import com.onboarding.application.entity.FamilyDetailsEntity;
import com.onboarding.application.entity.HobbiesEntity;
import com.onboarding.application.entity.PreviousEmploymentEntity;
import com.onboarding.application.entity.SkillEntity;
import com.onboarding.application.repository.EducationRepository;
import com.onboarding.application.repository.EmployeeDetailsRepository;
import com.onboarding.application.request.EmployeeRequestPojo;
import com.onboarding.application.responce.ResponcePojo;

import net.bytebuddy.asm.Advice.Enter;

@Service
public class OnboardingDaoImpl implements OnboardingDao {

	int Empid=0;
	
	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void onboardingDraft(EmployeeEntity employeeEntity) {
		employeeDetailsRepository.save(employeeEntity);
	}

	public void getUniqueId(EmployeeRequestPojo employeeRequestPojo) {
		employeeDetailsRepository.findByIdDetails(employeeRequestPojo.getEmpid());
	}

	// this is for update the status
	public void updateValues(EmployeeRequestPojo employeeRequestPojo, EmployeeEntity employeeEntity) {
//		 HobbiesEntity hobbiesEntity=new HobbiesEntity();
//       //  EmployeeEntity employee = employeeDetailsRepository.findById(employeeRequestPojo.getEmpid());
//         EmployeeEntity employeeEntity2=employeeDetailsRepository.findByTempId(employeeRequestPojo.getTempId());
//        
//		     if(employee.getStatus().equals("Draft")){
//			employeeDetailsRepository.updateStatus(employeeRequestPojo.getEmpid(),employeeEntity.getStatus());
//		    hobbiesRepository.updateStatus(employeeRequestPojo.getEmpid(),employeeRequestPojo.getHobbies());
//			bankDetailsRepository.updateStatus(employeeRequestPojo.getEmpid(),employeeRequestPojo.getBankName());
//		   educationRepository.updateStatus(employeeRequestPojo.getEmpid(),employeeRequestPojo.getEducation());
	}

	// }

	public List<Object> findAllByEmp() {
		return employeeDetailsRepository.fetchall();
	}

	public List<Object> fetchById(EmployeeRequestPojo employeeRequestPojo) {
		return employeeDetailsRepository.findByIdDetails(employeeRequestPojo.getEmpid());
	}

	@Override
	public List<Object> getById(EmployeeRequestPojo employeeRequestPojo) {

		return employeeDetailsRepository.fetchById(employeeRequestPojo.getEmpid());
	}
	

	// JdbcTemplate

	// Save Methods
	@Override
	public int saveEmployee(EmployeeRequestPojo employeeEntity) {
		return jdbcTemplate.update(
				"INSERT INTO employee (full_name,father_name,date_of_birth,marital_status,spouse_name,anniversary_date,"
						+ "pan_number,aadhaar_no,designation,department,employee_id,doj_tts,month_of_exp,gender_emp,driving_license_no,license_expiry_date,"
						+ "voter_id_no,passport_no,passport_expiry,native_place,ph_one,ph_two,blood_group,personal_email,offical_mail,"
						+ "present_address,permanent_address,skype_id,status,temp_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				new Object[] { employeeEntity.getFullName(), employeeEntity.getFatherName(),
						employeeEntity.getDateOfBirth(), employeeEntity.getMaritalStatus(),
						employeeEntity.getSpouseName(), employeeEntity.getAnniversaryDate(),
						employeeEntity.getPanNumber(), employeeEntity.getAadharNo(), employeeEntity.getDesignation(),
						employeeEntity.getDepartment(), employeeEntity.getEmployeeId(), employeeEntity.getDojTts(),
						employeeEntity.getMonthOfExp(), employeeEntity.getGenderEmp(),
						employeeEntity.getDrivinglicenseNo(), employeeEntity.getLicenseExpiryDate(),
						employeeEntity.getVoterIdNo(), employeeEntity.getPassportNo(),
						employeeEntity.getPassportExpiry(), employeeEntity.getNativePlace(),
						employeeEntity.getPhoneNoOne(), employeeEntity.getPhoneNoTwo(), employeeEntity.getBloodGroup(),
						employeeEntity.getPersonalEmail(), employeeEntity.getOfficalMail(),
						employeeEntity.getPresentAddress(), employeeEntity.getPermanentAddress(),
						employeeEntity.getSkypeId(), employeeEntity.getStatus(), employeeEntity.getTempId()});
		
	}

	@Override
	public int saveBank(EmployeeRequestPojo employeeEntity,int a) {
		String sql="SELECT MAX(empid) AS LargestPrice FROM employee";
		//int b=Integer.parseInt(sql);
		return jdbcTemplate.update(
				"INSERT INTO bank_details (bank_name,branch_name,account_number,ifsc_code,empid) VALUES(?,?,?,?,?)",
				new Object[] { employeeEntity.getBankName(),
						employeeEntity.getBranchName(),
						employeeEntity.getAccountNumber(),
						employeeEntity.getIfscCode() });
	}

	@Override
	public int[] batchHobbies(EmployeeRequestPojo employeeRequestPojo) {
		List<HobbiesEntity> hobbiesEntities = employeeRequestPojo.getHobbiesEntities();
		return this.jdbcTemplate.batchUpdate("insert into hobbies_details (hobbies,hobbies_level) values(?,?)",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, hobbiesEntities.get(i).getHobbies());
						ps.setString(2, hobbiesEntities.get(i).getHobbiesLevel());
					}

					public int getBatchSize() {
						return hobbiesEntities.size();
					}
				});
	}

	@Override
	public int[] batchSkill(EmployeeRequestPojo employeeRequestPojo) {
		List<SkillEntity> skillEntities = employeeRequestPojo.getSkillEntities();
		return this.jdbcTemplate.batchUpdate("insert into skill_set (skills,level_of_skill)VALUES(?,?)",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, skillEntities.get(i).getSkills());
						ps.setString(2, skillEntities.get(i).getLevelOfSkill());
					}

					public int getBatchSize() {
						return skillEntities.size();
					}
				});
	}

	@Override
	public int[] batchPerviousEmp(EmployeeRequestPojo employeeRequestPojo) {
		List<PreviousEmploymentEntity> previousEmploymentEntities = employeeRequestPojo.getPreviousEmploymentEntity();
		return this.jdbcTemplate.batchUpdate(
				"insert into previous_employment_details (company_name,pr_doj,pr_dor,ctc_doj,ctc_dor,role_doj,role_dor,esi_dispensary_name,"
						+ "pervious_emp_no,pervious_insurance_no) values(?,?,?,?,?,?,?,?,?,?)",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, previousEmploymentEntities.get(i).getCompanyName());
						ps.setString(2, previousEmploymentEntities.get(i).getPrDoj());
						ps.setString(3, previousEmploymentEntities.get(i).getPrDor());
						ps.setString(4, previousEmploymentEntities.get(i).getCtcDoj());
						ps.setString(5, previousEmploymentEntities.get(i).getCtcDor());
						ps.setString(6, previousEmploymentEntities.get(i).getRoleDoj());
						ps.setString(7, previousEmploymentEntities.get(i).getRoleDor());
						ps.setString(8, previousEmploymentEntities.get(i).getEsiDespensaryName());
						ps.setString(9, previousEmploymentEntities.get(i).getPerviousEmpNo());
						ps.setString(10, previousEmploymentEntities.get(i).getPerviousInsuranceNo());
					}

					public int getBatchSize() {
						return previousEmploymentEntities.size();
					}
				});

	}

	@Override
	public int[] batchFam(EmployeeRequestPojo employeeRequestPojo) {
		List<FamilyDetailsEntity> familyDetailsEntities = employeeRequestPojo.getFamilyDetailsEntities();
		return this.jdbcTemplate.batchUpdate(
				"insert into family_details (fam_full_name,members_dob,relationship,is_emergency,is_family_members"
						+ ") values(?,?,?,?,?)",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, familyDetailsEntities.get(i).getFamFullName());
						ps.setDate(2, familyDetailsEntities.get(i).getMembersDob());
						ps.setString(3, familyDetailsEntities.get(i).getRelationShip());
						ps.setBoolean(4, familyDetailsEntities.get(i).isEmergency());
						ps.setBoolean(5, familyDetailsEntities.get(i).isFamilyMembers());

					}

					public int getBatchSize() {
						return familyDetailsEntities.size();
					}
				});
	}

	@Override
	public int[] batchEducation(EmployeeRequestPojo employeeRequestPojo) {
		List<EducationEntity> educationEntities = employeeRequestPojo.getEducationEntities();
		return this.jdbcTemplate.batchUpdate(
				"insert into qualification_details (qualification,major_stream,institute_name,year_of_joining,"
						+ "year_of_passing,education_type,percentage) values(?,?,?,?,?,?,?)",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, educationEntities.get(i).getQualification());
						ps.setString(2, educationEntities.get(i).getMajorStream());
						ps.setString(3, educationEntities.get(i).getInstituteName());
						ps.setDate(4, educationEntities.get(i).getYearOfJoining());
						ps.setDate(5, educationEntities.get(i).getYearOfPassing());
						ps.setString(6, educationEntities.get(i).getEducationType());
						ps.setString(7, educationEntities.get(i).getPercentage());
					}

					public int getBatchSize() {
						return educationEntities.size();
					}
				});

	}

	@Override
	public int update(EmployeeRequestPojo employeeRequestPojo) {
		return jdbcTemplate.update(
				"UPDATE employee SET employee.full_name=?,employee.father_name=?" + "WHERE employee.empid=?",
				new Object[] { employeeRequestPojo.getFullName(), employeeRequestPojo.getFatherName(),
						employeeRequestPojo.getEmpid() });
	}

	@Override
	public int updateBank(EmployeeRequestPojo employeeRequestPojo) {
		return jdbcTemplate.update(
				"UPDATE bank_details SET bank_details.bank_name=?,bank_details.branch_name=?"
						+ "WHERE bank_details.empid=?",
				new Object[] { employeeRequestPojo.getBankName(), employeeRequestPojo.getBranchName(),
						employeeRequestPojo.getEmpid() });
	}
	
	@Override
	public int updateHobbies(EmployeeRequestPojo employeeRequestPojo, EmployeeEntity employeeEntity) {
		List<HobbiesEntity>hobbiesEntities=employeeRequestPojo.getHobbiesEntities();
		return jdbcTemplate.update(
				"UPDATE hobbies_details SET hobbies_details.hobbies=?,hobbies_details.hobbies_level=?,hobbies_details.hobbie_id=? "
						+ "WHERE hobbies_details.empid=hobbies_details.hobbie_id",
				new Object[] { hobbiesEntities.get(employeeRequestPojo.getEmpid()).getHobbies(), hobbiesEntities.get(employeeRequestPojo.getEmpid()),
					employeeRequestPojo.getEmpid()});
	}

	@Override
	public EmployeeEntity findById(EmployeeRequestPojo employeeRequestPojo) {
		return jdbcTemplate.queryForObject("Select * from  employee where empid=?",
				BeanPropertyRowMapper.newInstance(EmployeeEntity.class), employeeRequestPojo.getEmpid());

	}

	@Override
	public List<EmployeeEntity> findAll() {
		return null;
	}

}
