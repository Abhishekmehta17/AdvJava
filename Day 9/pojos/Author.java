package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends BaseEntityBookAuth {

	@Column(name = "first_name", length = 30)
	private String firstName;

	@Column(name = "last_name", length = 30)
	private String lastName;

	@Column(length = 50, unique = true, nullable = false)
	private String email;

	@Column(length = 50, unique = true, nullable = false)
	private String Password;

	@OneToMany(mappedBy = "assignedAuth", cascade = CascadeType.ALL)
	private List<Book> bookList = new ArrayList<>();

	public Author() {
		super();
	}

	public Author(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		Password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	public void addBook(Book b) {
		//parent --> child
		bookList.add(b);
		//child ---> parent
		b.setAssignedAuth(this);
	}
	
	public void removeBook(Book b) {
		bookList.remove(b);
		b.setAssignedAuth(null);
	}

}
