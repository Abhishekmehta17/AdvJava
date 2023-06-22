package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

public class ReStoreEmpImage {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			EmployeeDao dao = new EmployeeDaoImpl();
			System.out.println("Enter the employee Id");
			long empId = sc.nextLong();
			sc.nextLine();// reads off pending new line
			System.out.println("enter new file name with path");
			System.out.println(dao.restoreImage(empId, sc.nextLine()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
