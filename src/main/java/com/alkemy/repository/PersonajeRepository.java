package com.alkemy.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemy.models.Personaje;

public interface PersonajeRepository extends JpaRepository<Personaje, Integer >{
	
	
}

