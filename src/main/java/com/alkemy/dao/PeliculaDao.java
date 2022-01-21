package com.alkemy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemy.models.Pelicula;

public interface PeliculaDao extends JpaRepository<Pelicula, Integer>{
	
}
