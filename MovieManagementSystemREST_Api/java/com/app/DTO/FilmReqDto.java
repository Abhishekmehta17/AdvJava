package com.app.DTO;

import java.time.LocalDate;

import com.app.entities.Rating;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class FilmReqDto {

	private String filmName;
	private Integer ticketPrice;
	private LocalDate relaseDate;
	private Rating rating;
	private Integer pid;

}
