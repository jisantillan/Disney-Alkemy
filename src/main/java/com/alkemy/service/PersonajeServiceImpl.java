package com.alkemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.dao.PersonajeDao;
import com.alkemy.models.Personaje;

@Service
public class PersonajeServiceImpl implements PersonajeService{

	@Autowired
	private PersonajeDao personajeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Personaje> listarPersonajes() {
		return personajeDao.findAll();
	}


	@Override
	@Transactional()
	public void guardar(Personaje personaje) {
		personajeDao.save(personaje);
	}

	
	@Override
	@Transactional
	public void actualizar(Personaje personaje) {
		personajeDao.save(personaje);
		
	}

	@Override
	public Personaje getPersonaje(Personaje personaje) {
		return personajeDao.findById(personaje.getId()).orElse(null);
	}


	@Override
	public void eliminar(Personaje personaje) {
		personajeDao.deleteById(personaje.getId());
		
	}

}
