package com.training.controller;

import java.util.Collection;

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
import com.training.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	

	@DeleteMapping(value = "/products/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		return employeeService.deleteEmployee(id);
	}

	@PutMapping(value = "/products/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable("id") String id, @RequestBody EmployeeDTO employeeDTO) {
		return employeeService.updateEmployee(employeeDTO, id);
	}

	@PostMapping(value = "/products")
	public ResponseEntity<String> createProduct(@RequestBody EmployeeDTO employeeDTO) {
		return employeeService.addEmployee(employeeDTO);
	}

	@GetMapping(value = "/products")
	public ResponseEntity<Collection<EmployeeDTO>> getProduct() {
		return employeeService.viewEmployee();
	}

}