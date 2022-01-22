package com.alkemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemy.models.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
	
}
