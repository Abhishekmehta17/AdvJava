package com.app.service;

import java.util.List;

import com.app.entities.Product;

public interface ProductService{
	
	//add a method to get all products
	List<Product> getAllProducts();
	
	Product addProductDetails(Product transientProduct);
}
