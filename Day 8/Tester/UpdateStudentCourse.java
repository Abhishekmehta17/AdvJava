package tester;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class UpdateStudentCourse {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter the student pid and course you want to update");
			System.out.println(dao.updateStudentCourse(sc.nextInt(),Course.valueOf(sc.next().toUpperCase())));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
