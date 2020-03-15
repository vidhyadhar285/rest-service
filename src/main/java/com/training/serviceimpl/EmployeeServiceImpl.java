package com.training.serviceimpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.DTO.EmployeeDTO;
import com.training.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private static Map<String, EmployeeDTO> employeeRepo = new HashMap<>();

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
	

	@Override
	public ResponseEntity<String> addEmployee(EmployeeDTO employeeDTO) {
		employeeRepo.put(employeeDTO.getEmpId(), employeeDTO);
		return new ResponseEntity<>("employee is created successfully", HttpStatus.CREATED);
		
	}

	@Override
	public ResponseEntity<String> deleteEmployee(String id) {
		employeeRepo.remove(id);
		return new ResponseEntity<>("employee is deleted successsfully", HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<String> updateEmployee(EmployeeDTO employeeDTO,String id) {
		employeeRepo.remove(employeeDTO.getEmpId());
		employeeDTO.setEmpId(id);
		employeeRepo.put(id, employeeDTO);
		return new ResponseEntity<>("employee is updated successsfully", HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<Collection<EmployeeDTO>> viewEmployee() {
		return new ResponseEntity<>(employeeRepo.values(), HttpStatus.OK);
		
	}

}
