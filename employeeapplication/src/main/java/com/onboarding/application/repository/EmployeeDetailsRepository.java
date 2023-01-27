package com.onboarding.application.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.onboarding.application.entity.EmployeeEntity;
import com.onboarding.application.request.EmployeeRequestPojo;
import com.onboarding.application.responce.ResponcePojo;


@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeEntity, Integer> {
	
	@Modifying
	@Transactional
	@Query("UPDATE EmployeeEntity e Set e.status= :status where e.empid= :empid")
	public int updateStatus(int empid, @Param("status") String status);
	
	@Query("SELECT e.empid,e.fullName,q.qualification from EmployeeEntity e join EducationEntity q on e.empid=q.employeeEntity.empid where e.empid=?1")
	public List<Object> findByIdDetails(int empid);

	@Query("Select e.empid,e.fullName,e.fatherName,e.dateOfBirth,e.spouseName,e.anniversaryDate,e.panNumber,e.aadhaarNo,e.designation,e.department,e.dojTts,e.monthOfExp,e.genderEmp,e.drivinglicenseNo,e.licenseExpiryDate,e.voterIdNo,e.passportNo,e.passportExpiry"
	+ ",q.qualification,q.majorStream,q.instituteName,h.hobbieId,h.hobbiesLevel,h.hobbies"
    + " from EmployeeEntity e join EducationEntity q on e.empid=q.employeeEntity.empid join HobbiesEntity h on e.empid=h.employeeEntity.empid")
	List<Object> fetchall();

	@Query("select e.empid,e.fullName,e.fatherName,e.dateOfBirth,e.spouseName,e.anniversaryDate"
			+ ",q.qualification,q.majorStream,q.instituteName,h.hobbieId,h.hobbiesLevel,h.hobbies"
			+ " from EmployeeEntity e join EducationEntity q on e.empid=q.employeeEntity.empid join HobbiesEntity h on e.empid=h.employeeEntity.empid where e.empid=?1")
	List<Object> fetchById(int empid);

	public EmployeeEntity findByStatus(String status);

	public EmployeeEntity findByTempId(String tempId);

	public Optional<EmployeeEntity> findById(int empid);

	

}
