package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "students")
public class Student {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	@Id
	private int pid;

	@Column(name = "first_name", length = 20)
	private String firstName;

	@Column(name = "last_name", length = 20)
	private String lastName;

	@Column(length = 30, unique = true)
	private String email;

	@Column(length = 30, nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "course", length = 20)
	private Course enrolledCourse;

	@Column(nullable = false)
	private LocalDate dob;

	public Student() {

	}

	public Student(String firstName, String lastName, String email, String password, Course enrolledCourse,
			LocalDate dob) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.enrolledCourse = enrolledCourse;
		this.dob = dob;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Course getCourse() {
		return enrolledCourse;
	}

	public void setCourse(Course enrolledCourse) {
		this.enrolledCourse = enrolledCourse;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [pid=" + pid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", course=" + enrolledCourse + ", dob=" + dob + "]";
	}

}
