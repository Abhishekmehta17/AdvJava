package tester;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class StoreEmpImage {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in);) {
			EmployeeDao dao = new EmployeeDaoImpl();
			System.out.println("Enter the employee id");
			Long empId = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter file name with path");
			System.out.println(dao.storeImage(empId, sc.nextLine()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
