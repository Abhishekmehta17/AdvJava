package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="products")
public class Product extends BaseEntity {

	@Column(length = 30)
	private String pname;
	
	@Column(length = 30)
	private int qty;
	

	private double price;
	
	@Column(name = "dis" , length = 100)
	private String discription;

	public Product() {
		super();
	}

	public Product(String pname, int qty, double price, String discription) {
		super();
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.discription = discription;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "Product [pname=" + pname + ", qty=" + qty + ", price=" + price + ", discription=" + discription + "]";
	}
	
	
	
}
