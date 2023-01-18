package com.onboarding.application.Dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.onboarding.application.Dao.OnboardingDao;
import com.onboarding.application.entity.EducationEntity;
import com.onboarding.application.entity.EmployeeEntity;
import com.onboarding.application.entity.HobbiesEntity;
import com.onboarding.application.repository.BankDetailsRepository;
import com.onboarding.application.repository.EducationRepository;
import com.onboarding.application.repository.EmployeeDetailsRepository;
import com.onboarding.application.repository.HobbiesRepository;
import com.onboarding.application.request.EmployeeRequestPojo;
import com.onboarding.application.responce.ResponcePojo;

import net.bytebuddy.asm.Advice.Enter;

@Service
public class OnboardingDaoImpl implements OnboardingDao {

	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;
    @Autowired
	private BankDetailsRepository bankDetailsRepository;
	@Autowired
	private EducationRepository educationRepository;
	@Autowired
	private HobbiesRepository hobbiesRepository;
	
	public void onboardingDraft(EmployeeEntity employeeEntity) {
		employeeDetailsRepository.save(employeeEntity);

	}
	
	public void getUniqueId(EmployeeRequestPojo employeeRequestPojo) {
		employeeDetailsRepository.findByIdDetails(employeeRequestPojo.getEmpid());
	}
	
	// this is for update the status
	public void updateValues(EmployeeRequestPojo employeeRequestPojo,EmployeeEntity employeeEntity) {
		 HobbiesEntity hobbiesEntity=new HobbiesEntity();
       //  EmployeeEntity employee = employeeDetailsRepository.findById(employeeRequestPojo.getEmpid());
         EmployeeEntity employeeEntity2=employeeDetailsRepository.findByTempId(employeeRequestPojo.getTempId());
        
		    // if(employee.getStatus().equals("Draft")){
			//employeeDetailsRepository.updateStatus(employeeRequestPojo.getEmpid(),employeeEntity.getStatus());
		    //hobbiesRepository.updateStatus(employeeRequestPojo.getEmpid(),employeeRequestPojo.getHobbies());
			//bankDetailsRepository.updateStatus(employeeRequestPojo.getEmpid(),employeeRequestPojo.getBankName());
		   //educationRepository.updateStatus(employeeRequestPojo.getEmpid(),employeeRequestPojo.getEducation());
		}
		
	//}

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

	
}
