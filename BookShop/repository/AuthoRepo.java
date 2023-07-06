package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Author;

public interface AuthoRepo extends JpaRepository<Author, Long> {

}
