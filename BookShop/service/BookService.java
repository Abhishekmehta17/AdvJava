package com.app.service;

import java.util.List;

import com.app.entities.Books;

public interface BookService {

	List<Books> getAllBooks();
	
	Books addBooks(Books newBook);
}
