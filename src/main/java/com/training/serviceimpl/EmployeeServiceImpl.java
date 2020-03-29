package com.training.serviceimpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tarining.mongodb.repository.EmployeeRepository;
import com.training.DTO.EmployeeDTO;
import com.training.mongodb.Employee;
import com.training.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private static Map<String, EmployeeDTO> employeeRepo = new HashMap<>();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	static {
		EmployeeDTO employeeDTOOne = new EmployeeDTO();
		employeeDTOOne.setEmpId("1");
		employeeDTOOne.setEmpName("max");
		employeeRepo.put(employeeDTOOne.getEmpId(), employeeDTOOne);

		EmployeeDTO employeeDTOTwo = new EmployeeDTO();
		employeeDTOTwo.setEmpId("2");
		employeeDTOTwo.setEmpName("miller");
		employeeRepo.put(employeeDTOTwo.getEmpId(), employeeDTOTwo);
	}
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public ResponseEntity<String> addEmployee(EmployeeDTO employeeDTO) {
		LOGGER.info("In addEmployee method of EmployeeServiceImpl");
		employeeRepo.put(employeeDTO.getEmpId(), employeeDTO);
		return new ResponseEntity<>("employee is created successfully", HttpStatus.CREATED);
		
	}

	@Override
	public ResponseEntity<String> deleteEmployee(String id) {
		LOGGER.info("In deleteEmployee method of EmployeeServiceImpl");
		employeeRepo.remove(id);
		return new ResponseEntity<>("employee is deleted successsfully", HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<String> updateEmployee(EmployeeDTO employeeDTO,String id) {
		LOGGER.info("In updateEmployee method of EmployeeServiceImpl");
		employeeRepo.remove(employeeDTO.getEmpId());
		employeeDTO.setEmpId(id);
		employeeRepo.put(id, employeeDTO);
		return new ResponseEntity<>("employee is updated successsfully", HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<Collection<EmployeeDTO>> viewEmployee() {
		LOGGER.info("In viewEmployee method of EmployeeServiceImpl");
		return new ResponseEntity<>(employeeRepo.values(), HttpStatus.OK);
		
	}

	@Override
	public List<Employee> viewMongoEmployee() {
		LOGGER.info("In viewMongoEmployee method of EmployeeServiceImpl");
		return employeeRepository.findAll();
	}
	
	@Override
	public ResponseEntity<String> addMongoEmployee(EmployeeDTO employeeDTO) {
		LOGGER.info("In addMongoEmployee method of EmployeeServiceImpl");
		Employee employee=new Employee();
		employee.setEmpId(employeeDTO.getEmpId());
		employee.setEmpName(employeeDTO.getEmpName());
		employeeRepository.save(employee);
		return new ResponseEntity<>("employee is created successfully", HttpStatus.CREATED);
		
	}
	
	@Override
	public ResponseEntity<String> updateMongoEmployee(EmployeeDTO employeeDTO,String id) {
		LOGGER.info("In updateMongoEmployee method of EmployeeServiceImpl");
		Employee employee=employeeRepository.fetchByEmpId(id);
		employee.setEmpName(employeeDTO.getEmpName());
		employeeRepository.save(employee);
		return new ResponseEntity<>("employee is updated successsfully", HttpStatus.OK);
		
	}
	
	@Override
	public ResponseEntity<String> deleteMongoEmployee(String id) {
		LOGGER.info("In deleteMongoEmployee method of EmployeeServiceImpl");
		Employee employee=employeeRepository.fetchByEmpId(id);
		employeeRepository.delete(employee);
		return new ResponseEntity<>("employee is deleted successsfully", HttpStatus.OK);
		
	}

}
