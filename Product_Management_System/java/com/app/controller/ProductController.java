package com.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.app.entities.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3001")

public class ProductController {
	@Autowired
	private ProductService prdService;

	public ProductController(ProductService prdService) {
		System.out.println("in default cons");
	}
	
	//http://localhost:8080/products/ method get 
	//add a request handling method to return list of product
	@GetMapping
	public List<Product> listpdts(){
		System.out.println("in the list of product");
		return prdService.getAllProducts();
	}
	
	public Product saveProductdetails(@RequestBody Product transientProduct)
	{
		System.out.println("in save" +transientProduct);
		return prdService.addProductDetails(transientProduct);
	}
	
}
