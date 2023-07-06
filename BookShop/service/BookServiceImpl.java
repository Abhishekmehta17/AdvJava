package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Books;
import com.app.repository.BookRepo;
@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepoInstance;
	
	@Override
	public List<Books> getAllBooks() {
		
		return bookRepoInstance.findAll();
	}

	@Override
	public Books addBooks(Books newBook) {
		
		return bookRepoInstance.save(newBook);
	}

}
