package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "password")
@JsonIgnoreType
public class Producer extends BaseEntity {

	@Column(unique = true)
	private String producerName;

	private Integer age;

	@Email
	private String email;

	@Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{5,10}$")
	private String password;

	@Past
	private LocalDate dob;

	@OneToMany(mappedBy = "producer", fetch = FetchType.EAGER)
	private List<Film> filmList = new ArrayList<>();

	public Producer(String producerName, Integer age, @Email String email,
			@Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{5,10}$") String password,
			@Past LocalDate dob) {
		super();
		this.producerName = producerName;
		this.age = age;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}

	// helper method
	public boolean addFilm(Film newFilms) {

		filmList.add(newFilms);
		newFilms.setProducer(this);
		return true;
	}

}
