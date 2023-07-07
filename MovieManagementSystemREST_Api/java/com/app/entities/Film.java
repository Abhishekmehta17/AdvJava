package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@JsonIgnoreType
public class Film extends BaseEntity {
	// data,name,producer,ticketPrice,ratings

	@Column(unique = true, length = 50)
	private String filmName;

	private int ticketPrice;

	@Enumerated(EnumType.STRING)
	private Rating rating;

	@ManyToOne
	private Producer producer;

	@Past
	private LocalDate relaseDate;

	public Film(String filmName, int ticketPrice, Rating rating, @Past LocalDate relaseDate) {
		super();
		this.filmName = filmName;
		this.ticketPrice = ticketPrice;
		this.rating = rating;
		this.relaseDate = relaseDate;
	}

}
