package com.training.service;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.training.DTO.EmployeeDTO;
import com.training.mongodb.Employee;

public interface EmployeeService {
	
	public ResponseEntity<String> addEmployee(EmployeeDTO employeeDTO);
	public ResponseEntity<String> deleteEmployee(String id);
	public ResponseEntity<String> updateEmployee(EmployeeDTO employeeDTO,String id);
	public ResponseEntity<Collection<EmployeeDTO>> viewEmployee();
	public List<Employee> viewMongoEmployee();
	public ResponseEntity<String> addMongoEmployee(EmployeeDTO employeeDTO);
	public ResponseEntity<String> updateMongoEmployee(EmployeeDTO employeeDTO,String id);
	public ResponseEntity<String> deleteMongoEmployee(String id);
	

}
