package tester;

import org.hibernate.SessionFactory;

import dao.AuthorDaoImpl;
import pojos.Author;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class AddNewAuthor {

	public static void main(String[] args) {
		try(SessionFactory sf =getFactory(); 
				Scanner sc = new Scanner(System.in);){
			//create instanc of daoImpl		
			AuthorDaoImpl dao = new AuthorDaoImpl();
			System.out.println("Enter auth details :first name ,last name , email ,Password");
			System.out.println(dao.launchNewAuthor(new Author(sc.next(),sc.next(),sc.next(),sc.next())));
		}//sf.close()--> cleaning up DBCP (DB connection pool)
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
