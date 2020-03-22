package com.training.controller;

import java.util.Collection;
import java.util.List;

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

	

	@DeleteMapping(value = "/employee/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		return employeeService.deleteEmployee(id);
	}

	@PutMapping(value = "/employee/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable("id") String id, @RequestBody EmployeeDTO employeeDTO) {
		return employeeService.updateEmployee(employeeDTO, id);
	}

	@PostMapping(value = "/employee")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return employeeService.addEmployee(employeeDTO);
	}

	@GetMapping(value = "/employees")
	public ResponseEntity<Collection<EmployeeDTO>> getEmployees() {
		return employeeService.viewEmployee();
	}
	
	@GetMapping(value = "/mongodb/employees")
	public ResponseEntity<List<Employee>> fetchEmployees() {
		List<Employee>  employees=employeeService.viewMongoEmployee();
		return ResponseEntity.ok(employees);
	}
	
	@PostMapping(value = "/mongodb/employee")
	public ResponseEntity<String> createMongoEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return employeeService.addMongoEmployee(employeeDTO);
	}
	
	@PutMapping(value = "/mongodb/employee/{id}")
	public ResponseEntity<String> updateMongoEmployee(@PathVariable("id") String id, @RequestBody EmployeeDTO employeeDTO) {
		return employeeService.updateMongoEmployee(employeeDTO, id);
	}
	
	@DeleteMapping(value = "/mongodb/employee/{id}")
	public ResponseEntity<String> deleteMongoEmployee(@PathVariable("id") String id) {
		return employeeService.deleteMongoEmployee(id);
	}

}
