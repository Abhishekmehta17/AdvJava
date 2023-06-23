package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {
	// add a method to get list of emps , by dept_id
	List<Employee> getAllEmpsByDeptId(Long deptId);

	//add employee-->pojo authentication method 
	Employee authenticateEmp(String email,String password);
}
