package dao;

import java.util.List;

import pojos.Course;
import pojos.Student;

public interface StudentDao {
//add a method to insert new student details
	String insertStudentDetails(Student stud);
	
	//add a method to insert new stud details : using getCurrentSession
	//String a method to login
	String studentLogin(String email,String pwd);
	
	//add a method to get student name by student type 
	List<String> getNameOfStudentByType(Course studentType);
	
	//add a method to update student course
	Student updateStudentCourse(Integer pid,Course course);
}
