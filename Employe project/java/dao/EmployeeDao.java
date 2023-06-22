package dao;

import java.io.IOException;
import java.sql.SQLException;

import pojos.Employee;

public interface EmployeeDao {
//add new emp
	String addNewEmployee(Employee emp, long deptId);

	// delete emp details
	String deleteEmpDetails(String deptName, String empEmail);

	Employee getEmpDetails(long nextLong);
	
	//add a method for storing emp image in DB
	String storeImage(long empId,String path) throws IOException;
	
	//add a method for re storing emp image from DB
	String restoreImage(long empId,String path) throws IOException;
}
