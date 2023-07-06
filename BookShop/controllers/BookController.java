package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Books;
import com.app.service.BookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookServiceInstance;
	
	@GetMapping("/details")
	public List<Books> getAllBooks(){
		
		
		return bookServiceInstance.getAllBooks();
	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody Books newbookObj) {
		
		 Books addBooks =bookServiceInstance.addBooks(newbookObj);
		return "new book added";
	}

}
