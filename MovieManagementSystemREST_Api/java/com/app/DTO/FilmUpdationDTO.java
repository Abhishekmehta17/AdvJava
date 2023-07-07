package com.app.DTO;

import java.time.LocalDate;

import com.app.entities.Rating;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class FilmUpdationDTO {

	private Integer id;
	private String filmName;
	private int ticketPrice;
	private LocalDate relaseDate;
	private Rating rating;
	private Integer pid;

}
