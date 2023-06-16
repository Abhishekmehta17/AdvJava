package tester;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

public class AddStudentDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter student details : firstName,lastName,email,password,enrolledCourse,dob");
			Student newStudent = new Student(sc.next(), sc.next(), sc.next(), sc.next(),
					Course.valueOf(sc.next().toUpperCase()), LocalDate.parse(sc.next()));
			System.out.println(dao.insertStudentDetails(newStudent));
			
		} //sf.close-->cleaning up DBCP (db con pool)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
