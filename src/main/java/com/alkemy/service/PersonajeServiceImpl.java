package com.alkemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.models.Personaje;
import com.alkemy.repository.PersonajeRepository;

@Service
public class PersonajeServiceImpl implements PersonajeService{

	@Autowired
	private PersonajeRepository personajeDao;
	
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
	public Personaje getPersonaje(Integer id) {
		return personajeDao.findById(id).orElse(null);
	}


	@Override
	public void eliminar(Integer id) {
		personajeDao.deleteById(id);
		
	}

}
