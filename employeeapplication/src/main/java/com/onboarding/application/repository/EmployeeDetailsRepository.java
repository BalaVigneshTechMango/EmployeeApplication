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
	
//	@Modifying
//	@Transactional
//	@Query("UPDATE EmployeeEntity e join EducationEntity q SET e.status= :status,q.qualification=:qualification where e.empid= :empid")
//	public int updateStatuss(@Param("empid") int empid, @Param("status") String status);
	
//	@Modifying
//	@Transactional
//	@Query("UPDATE EmployeeEntity e, EducationEntity q Set e.status= :status,"
//			+ " q.qualification= :qualification  where e.empid= q.employeeEntity.empid")
//	public int updateStatus(int empid, @Param("status") String status);
	
	@Query("SELECT e.empid,e.fullName,q.qualification from EmployeeEntity e join EducationEntity q on e.empid=q.employeeEntity.empid where e.empid=?1")
	public List<Object> findByIdDetails(int empid);

	@Query("Select e.empid,e.fullName,e.fatherName,e.dateOfBirth,e.spouseName,e.anniversaryDate"
	+ ",q.qualification,q.majorStream,q.instituteName,h.hobbieId,h.hobbiesLevel,h.hobbies"
    + " from EmployeeEntity e join EducationEntity q on e.empid=q.employeeEntity.empid join HobbiesEntity h on e.empid=h.employeeEntity.empid")
	List<Object> fetchall();

	@Query("select e.empid,e.fullName,e.fatherName,e.dateOfBirth,e.spouseName,e.anniversaryDate"
			+ ",q.qualification,q.majorStream,q.instituteName,h.hobbieId,h.hobbiesLevel,h.hobbies"
			+ " from EmployeeEntity e join EducationEntity q on e.empid=q.employeeEntity.empid join HobbiesEntity h on e.empid=h.employeeEntity.empid where e.empid=?1")
	List<Object> fetchById(int empid);

   // public EmployeeEntity findById(int empid);

// @Modifying
// @Transactional
// @Query("UPDATE EmployeeEntity e,EducationEntity q SET e.status= :status,q.qualification= :qualification where empid= :empid")
// public int updateQuery(@Param("empid")int empid,@Param("status")String status,@Param("qualification")String qualification);

//@Query("select e.fullName,q.qualification From EmployeeEntity e join EducationEntity q on e.empid=q.empid")
//public ArrayList getAllEmployeeDetails();

//public final static String employee_details="select e.fullName,q.qualification from EmployeeEntity e join EducationEntity q on e.empid=q.employeeEntity.empid";	
//@Query(employee_details)
//public int findByIdDetails(@Param("empid")int empid);

	public EmployeeEntity findByStatus(String status);

	public EmployeeEntity findByTempId(String tempId);

	public Optional<EmployeeEntity> findById(int empid);

	//public Optional<EmployeeEntity> findBy(int empid);

}
