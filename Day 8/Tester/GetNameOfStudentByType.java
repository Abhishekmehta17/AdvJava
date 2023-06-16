package tester;

//import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class GetNameOfStudentByType {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {

			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter student type");
			System.out.println("list of selected  student name : ");
			dao.getNameOfStudentByType(Course.valueOf(sc.next().toUpperCase())).forEach(System.out::println);
		} // sf.close()--->cleaning up DBCP (DB conn pool)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
