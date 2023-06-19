package dao;

import pojos.Author;
import pojos.Book;

public interface BookDao {
	
	String addnewBook(Book book,String email);

}
