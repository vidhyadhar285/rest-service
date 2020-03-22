package com.tarining.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.mongodb.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
	 @Query("{ 'empId' : ?0 }")
	public Employee fetchByEmpId(String id);

}
