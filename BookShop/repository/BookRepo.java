package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Books;

public interface BookRepo extends JpaRepository<Books, Long> {

}
