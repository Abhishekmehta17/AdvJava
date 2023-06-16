package tester;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class StundentLogin {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) 
		{
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter student email and password");
			System.out.println(dao.studentLogin(sc.next(),sc.next()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
