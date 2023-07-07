package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.DTO.FilmReqDto;
import com.app.DTO.FilmUpdationDTO;
import com.app.entities.Film;
import com.app.entities.Producer;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.FilmRepoIF;
import com.app.repository.ProducerRepoIF;

@Service
@Transactional
public class FilmServiceImpl implements FilmServiceIF {

	@Autowired
	private FilmRepoIF filmRepoInstance;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ProducerRepoIF producerRepoInstance;

	@Override
	public List<Film> getdetails() {
		List<Film> findAllFilms = filmRepoInstance.findAll();
		return findAllFilms;
	}

	@Override
	public Film insertNewFilm(FilmReqDto filmreqDTO) {
		Integer pId = filmreqDTO.getPid();
		Producer foundProducer = producerRepoInstance.findById(pId)
				.orElseThrow(() -> new ResourceNotFoundException("OOPSSSsss!!! Its Invalid producer ID.."));
		Film newFilm = mapper.map(filmreqDTO, Film.class);
		foundProducer.addFilm(newFilm);
		filmRepoInstance.save(newFilm);

		return newFilm;
	}

	@Override
	public Film updateFilm(FilmUpdationDTO filmupdationDTO) {
		Integer filmID = filmupdationDTO.getId();
		Film filmToUpdate = filmRepoInstance.findById(filmID).orElseThrow(()->new ResourceNotFoundException("DARLING!!!! This is not a valid Film ID..."));
		
		filmToUpdate.setFilmName(filmupdationDTO.getFilmName());
		filmToUpdate.setTicketPrice(filmupdationDTO.getTicketPrice());
		filmToUpdate.setRating(filmupdationDTO.getRating());
		filmToUpdate.setRelaseDate(filmupdationDTO.getRelaseDate());
		
		Film updateFilm = filmRepoInstance.save(filmToUpdate);
		
		
		
		return updateFilm;
	}

	@Override
	public String deleteFilm(Integer FilmID) {
		String msg = "Oops!!!! Film does not get Deleted!!!!";
		boolean existStatus = filmRepoInstance.existsById(FilmID);
		
		if(existStatus) {
			filmRepoInstance.deleteById(FilmID);
			msg = "Yehoooo!!! Film get Deleted Congratulation!!!";
		}
		return msg;
	}

}
