package com.training.service;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import com.training.DTO.EmployeeDTO;

public interface EmployeeService {
	
	public ResponseEntity<String> addEmployee(EmployeeDTO employeeDTO);
	public ResponseEntity<String> deleteEmployee(String id);
	public ResponseEntity<String> updateEmployee(EmployeeDTO employeeDTO,String id);
	public ResponseEntity<Collection<EmployeeDTO>> viewEmployee();
	

}
