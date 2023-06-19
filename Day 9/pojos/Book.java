package pojos;

import javax.persistence.*;

@Entity
@Table(name= "books")
public class Book extends BaseEntityBookAuth{
	
	public Author getAssignedAuth() {
		return assignedAuth;
	}

	public void setAssignedAuth(Author assignedAuth) {
		this.assignedAuth = assignedAuth;
	}

	@Column(name="book_title", length =30)
	private String bookTitle;
	
	@Column(name="book_price", length =30, nullable=false)
	private double bookPrice;
	
	@ManyToOne
	@JoinColumn(name = "author_Id")
	private Author assignedAuth;
	

	public Book() {
		super();
	}

	public Book(String bookTitle, double bookPrice) {
		super();
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + "]";
	}

}
