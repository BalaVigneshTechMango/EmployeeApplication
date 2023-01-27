package com.onboarding.application.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

import com.onboarding.application.dao.OnboardingDao;
import com.onboarding.application.entity.EducationEntity;
import com.onboarding.application.entity.EmployeeEntity;
import com.onboarding.application.entity.HobbiesEntity;
import com.onboarding.application.repository.EducationRepository;
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
	@Autowired
	private OnboardingDao onboardingDao;
	@Autowired
	private EducationRepository educationRepository;

	@PostMapping("/batchUpdate")
	public void batchUpdate(@RequestBody EmployeeRequestPojo employeeRequestPojo) {
        
		onboardingService.saveEmployee(employeeRequestPojo);
		int a= employeeRequestPojo.getEmpid();
		onboardingService.saveBank(employeeRequestPojo,a);
		onboardingService.batchHobbies(employeeRequestPojo);
		onboardingService.batchSkill(employeeRequestPojo);
		onboardingService.batchPerviousEmp(employeeRequestPojo);
		onboardingService.batchFam(employeeRequestPojo);
		onboardingService.batchEducation(employeeRequestPojo);

	}

	@PostMapping("/updateExm")
	public void updateExample(@RequestBody EmployeeRequestPojo employeeRequestPojo) {
		onboardingDao.update(employeeRequestPojo);
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setHobbiesEntities(employeeRequestPojo.getHobbies());
		onboardingDao.updateHobbies(employeeRequestPojo, employeeEntity);

	}

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

	@PostMapping("/submit")
	public ResponcePojo updates(@RequestBody EmployeeRequestPojo employeeRequestPojo, EmployeeEntity employeeEntity) {
		ResponcePojo responcePojo = new ResponcePojo();
		EmployeeEntity employeeEntityy = onboardingDao.findById(employeeRequestPojo);
		if (employeeEntityy == null) {
			UUID uuid = UUID.randomUUID();
			String a = uuid.toString();
			employeeEntity.setStatus("Submitted");
			onboardingService.onboardingDraft(employeeRequestPojo, employeeEntity);
		} else if (employeeEntityy != null) {
			employeeEntity.setStatus("Submitted");
			EmployeeEntity employee = employeeEntityy;
			onboardingService.draftUpate(employeeRequestPojo, employeeEntity, employee);
			responcePojo.setObj(employee);
			return responcePojo;
		}
		// else {
//			employeeEntity.setStatus("submitted");
//			onboardingService.updateValues(employeeRequestPojo, employeeEntity);
//		}
		responcePojo.setObj(employeeRequestPojo);
		return responcePojo;
	}

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

	@PostMapping("/putmappingg")
	public ResponcePojo putMapping(@RequestBody EmployeeRequestPojo employeeRequestPojo) {
		ResponcePojo responcePojo = new ResponcePojo();
		Optional<EmployeeEntity> employeeData = employeeDetailsRepository.findById(employeeRequestPojo.getEmpid());
		if (employeeData.isPresent()) {
			EmployeeEntity employee = employeeData.get();
//			employee.setFullName(employeeRequestPojo.getFullName());
			employee.setEducationEntity(employeeRequestPojo.getEducation());
			employeeDetailsRepository.save(employee);
			responcePojo.setObj(employee);
			return responcePojo;
		}
		return responcePojo;
	}

	@PostMapping("educationEntity")
	public ResponcePojo educationEntity(@RequestBody EmployeeRequestPojo employeeRequestPojo) {
		ResponcePojo responcePojo = new ResponcePojo();
		Optional<EducationEntity> educationEntity = educationRepository.findById(employeeRequestPojo.getqId());
		if (educationEntity.isPresent()) {
			educationRepository.updateStatus(employeeRequestPojo.getqId(), employeeRequestPojo.getEducation());
//           EducationEntity educationEntity2=educationEntity.get();
//           educationEntity2.getEmployeeEntity().setEducationEntity(employeeRequestPojo.getEducation());
//           educationRepository.save(educationEntity2);
//           responcePojo.setObj(educationEntity2);
			return responcePojo;
		}
		return responcePojo;
	}

}
