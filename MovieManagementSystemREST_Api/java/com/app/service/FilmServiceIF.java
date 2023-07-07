package com.app.service;

import java.util.List;

import com.app.DTO.FilmReqDto;
import com.app.DTO.FilmUpdationDTO;
import com.app.entities.Film;

public interface FilmServiceIF {

	List<Film> getdetails();

	Film insertNewFilm(FilmReqDto req);
	
	Film updateFilm(FilmUpdationDTO filmupdationDTO);
	
	String deleteFilm(Integer FilmID);

}
