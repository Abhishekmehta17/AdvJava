package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmpsByDeptId(Long deptId) {
		// dept: empdao

		return employeeDao.findByAssignedDeptId(deptId);
	}

	@Override
	public Employee authenticateEmp(String email, String password) {
		System.out.println("in authentication " +getClass());
		// return to the caller by method name findByEmailAndPassword
		return employeeDao.findByEmailAndPassword(email, password);
	}

}
