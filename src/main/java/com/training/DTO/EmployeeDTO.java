package com.training.DTO;

import java.io.Serializable;

public class EmployeeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String empId;
	private String empName;
	
	public EmployeeDTO() {
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	

}
