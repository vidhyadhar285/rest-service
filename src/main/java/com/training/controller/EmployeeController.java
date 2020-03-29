package com.training.controller;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.DTO.EmployeeDTO;
import com.training.mongodb.Employee;
import com.training.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	

	@DeleteMapping(value = "/employee/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		LOGGER.debug("In delete method of EmployeeController");
		return employeeService.deleteEmployee(id);
	}

	@PutMapping(value = "/employee/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable("id") String id, @RequestBody EmployeeDTO employeeDTO) {
		LOGGER.debug("In updateEmployee method of EmployeeController");
		return employeeService.updateEmployee(employeeDTO, id);
	}

	@PostMapping(value = "/employee")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		LOGGER.debug("In createEmployee method of EmployeeController");
		return employeeService.addEmployee(employeeDTO);
	}

	@GetMapping(value = "/employees")
	public ResponseEntity<Collection<EmployeeDTO>> getEmployees() {
		LOGGER.debug("In createEmployee method of EmployeeController");
		return employeeService.viewEmployee();
	}
	
	@GetMapping(value = "/mongodb/employees")
	public ResponseEntity<List<Employee>> fetchEmployees() {
		LOGGER.debug("In fetchEmployees method of EmployeeController");
		List<Employee>  employees=employeeService.viewMongoEmployee();
		return ResponseEntity.ok(employees);
	}
	
	@PostMapping(value = "/mongodb/employee")
	public ResponseEntity<String> createMongoEmployee(@RequestBody EmployeeDTO employeeDTO) {
		LOGGER.debug("In createMongoEmployee method of EmployeeController");
		return employeeService.addMongoEmployee(employeeDTO);
	}
	
	@PutMapping(value = "/mongodb/employee/{id}")
	public ResponseEntity<String> updateMongoEmployee(@PathVariable("id") String id, @RequestBody EmployeeDTO employeeDTO) {
		LOGGER.debug("In updateMongoEmployee method of EmployeeController");
		return employeeService.updateMongoEmployee(employeeDTO, id);
	}
	
	@DeleteMapping(value = "/mongodb/employee/{id}")
	public ResponseEntity<String> deleteMongoEmployee(@PathVariable("id") String id) {
		LOGGER.debug("In deleteMongoEmployee method of EmployeeController");
		return employeeService.deleteMongoEmployee(id);
	}

}
