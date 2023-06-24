package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Product;
import com.app.repository.ProductRepository;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository pdtRepo;
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pdtRepo.findAll();
	}

	@Override
	public Product addProductDetails(Product transientProduct) {
		// TODO Auto-generated method stub
		return pdtRepo.save(transientProduct);
	}

}
