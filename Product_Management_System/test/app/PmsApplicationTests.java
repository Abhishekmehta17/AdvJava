package com.app.repository;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Product;

@DataJpaTest// Spring boot supplied annotation for testing ONLY (dao=repository) layer
@AutoConfigureTestDatabase(replace = Replace.NONE )// tell the spring boot that not to replace the original DB, configured in app properties
@Rollback(false)
class ProductRepositoryTest {
	@Autowired
	private ProductRepository pdtrepo;
	
	@Test
	void testSaveAllpdts() {
		List<Product> list = List.of(
				new Product("ipad" ,2,15000,"apple"),
				new Product("pc" ,3,195000,"mac"),
				new Product("Mobile" ,10,5000,"nokia"),
				new Product("Mobile" ,1,15000,"iphone"));
		List<Product> list1 = pdtrepo.saveAll(list);
		assertEquals(4,list1.size());
	}	

}
