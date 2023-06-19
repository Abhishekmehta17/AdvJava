package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.BookDaoImpl;
import pojos.Book;

public class AddNewBookByEmail {
	
	public static void main(String[] args) {
		
	
	try(SessionFactory SF = getFactory(); Scanner sc = new Scanner(System.in);){
		
		BookDaoImpl BookDAOInstance = new BookDaoImpl();
		
		System.out.println(" | Book Title | Price | ");
		Book newBook = new Book(sc.next(),sc.nextDouble());
		
		System.out.println(" | Email | ");
		
		System.out.println(BookDAOInstance.addnewBook(newBook, sc.next()));
		
		
	}catch(Exception e) {
		
		e.printStackTrace();
		
	}
}
}
