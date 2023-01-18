package com.onboarding.application.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onboarding.application.entity.EmployeeEntity;
import com.onboarding.application.repository.EmployeeDetailsRepository;
import com.onboarding.application.request.EmployeeRequestPojo;
import com.onboarding.application.responce.ResponcePojo;
import com.onboarding.application.service.OnboardingService;

@RestController
@RequestMapping("onboarding")
public class OnboardingController {

	@Autowired
	private OnboardingService onboardingService;

	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	@PostMapping("/temporary")
	public ResponcePojo onboardDraft(@RequestBody EmployeeRequestPojo employeeRequestPojo,
			EmployeeEntity employeeEntity) {
		ResponcePojo responcePojo = new ResponcePojo();
		UUID uuid = UUID.randomUUID();
		String a = uuid.toString();
		employeeEntity.setTempId(a);
		employeeEntity.setStatus("Draft");
		onboardingService.onboardingDraft(employeeRequestPojo, employeeEntity);
		responcePojo.setObj(employeeRequestPojo);
		return responcePojo;
	}

//	@PostMapping("/submit")
//	public ResponcePojo updates(@RequestBody EmployeeRequestPojo employeeRequestPojo, EmployeeEntity employeeEntity) {
//		ResponcePojo responcePojo = new ResponcePojo();
//		EmployeeEntity employeeEntityy = employeeDetailsRepository.findById(employeeRequestPojo.getEmpid());
//		if (employeeEntityy == null) {
//			UUID uuid = UUID.randomUUID();
//			String a = uuid.toString();
//			employeeEntity.setStatus("Submitted");
//			onboardingService.onboardingDraft(employeeRequestPojo, employeeEntity);
//		} else {
//			employeeEntity.setStatus("submitted");
//			onboardingService.updateValues(employeeRequestPojo, employeeEntity);
//		}
//		responcePojo.setObj(employeeRequestPojo);
//		return responcePojo;
//	}

	@PostMapping("/fetchAll")
	public List<Object> findAllEmployeeEntity() {
		return onboardingService.findAllByEmp();
	}

	@PostMapping("/fetchById")
	public Object detailsById(@RequestBody EmployeeRequestPojo employeeRequestPojo) {
		return onboardingService.getById(employeeRequestPojo);
	}

	@PostMapping("/detailsFetch")
	public ResponcePojo fetchById(@RequestBody EmployeeRequestPojo employeeRequestPojo) {
		ResponcePojo responcePojo = new ResponcePojo();
		responcePojo.setObj(onboardingService.fetchById(employeeRequestPojo));
		return responcePojo;

	}

	@PutMapping("/putmapping")
	public ResponcePojo putMapping(@RequestBody EmployeeRequestPojo employeeRequestPojo,
			EmployeeEntity employeeEntity) {
		ResponcePojo responcePojo = new ResponcePojo();
		onboardingService.onboardingDraft(employeeRequestPojo, employeeEntity);
		responcePojo.setObj(employeeRequestPojo);
		return responcePojo;
	}

    @PutMapping("/putmappingg")
	public ResponcePojo putMapping(@RequestBody EmployeeRequestPojo employeeRequestPojo) {
		ResponcePojo responcePojo = new ResponcePojo();
		Optional<EmployeeEntity> employeeData = employeeDetailsRepository.findById(employeeRequestPojo.getEmpid());
		if(employeeData.isPresent()) {
			EmployeeEntity employee=employeeData.get();
			employee.setFullName(employeeRequestPojo.getFullName());
			employee.setEducationEntity(employeeRequestPojo.getEducation());
			employeeDetailsRepository.save(employee);
			responcePojo.setObj(employee);
		}
		return responcePojo;
		
		
	}
//	
//	@GetMapping("/getjoindata")
//	public ResponseEntity<List<Object>> getJoinInfo() {
//		List<Object> employees = null;
//		try {
//			employees = employeeDetailsRepository.fetchall();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (employees.isEmpty())
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		return new ResponseEntity<List<Object>>(employees, HttpStatus.OK);
//
//	}

}
