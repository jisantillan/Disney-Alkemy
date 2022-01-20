package com.alkemy.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemy.models.Personaje;

public interface PersonajeDao extends JpaRepository<Personaje, Integer >{
	
	
}

