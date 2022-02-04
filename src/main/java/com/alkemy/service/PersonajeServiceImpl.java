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
	public Iterable<Object[]> listarPersonajes() {
		Iterable<Object[]>personajes = personajeDao.listar();
		  	return personajes;
	}


	@Override
	public Personaje listarPorId(Integer id) {
		return personajeDao.findById(id).orElse(null);
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
	public void eliminar(Integer id) {
		personajeDao.deleteById(id);
		
	}


	@Override
	public Iterable<Object[]> buscarPorNombre(String nombre) {
		return personajeDao.buscarPorNombre(nombre);
	}


	@Override
	public Iterable<Object[]> buscarPorEdad(Integer edad) {
		return personajeDao.buscarPorEdad(edad);
	}


	@Override
	public Iterable<Object[]> buscarPorIdPelicula(Integer id) {
		return personajeDao.buscarPorIdPelicula(id);
	}





}
