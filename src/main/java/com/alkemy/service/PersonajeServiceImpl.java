package com.alkemy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.entity.Personaje;
import com.alkemy.repository.PersonajeRepository;

@Service
public class PersonajeServiceImpl implements PersonajeService{

	@Autowired
	private PersonajeRepository personajeRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Object[]> listarPersonajes() {
		Iterable<Object[]>personajes = personajeRepository.listar();
		  	return personajes;
	}


	@Override
	public Personaje listarPorId(Integer id) {
		return personajeRepository.findById(id).orElse(null);
	}
	@Override
	@Transactional()
	public void guardar(Personaje personaje) {
		personajeRepository.save(personaje);
	}


	@Override
	public void eliminar(Integer id) {
		personajeRepository.deleteById(id);
		
	}


	@Override
	public Iterable<Object[]> buscarPorNombre(String nombre) {
		return personajeRepository.buscarPorNombre(nombre);
	}


	@Override
	public Iterable<Object[]> buscarPorEdad(Integer edad) {
		return personajeRepository.buscarPorEdad(edad);
	}


	@Override
	public Iterable<Object[]> buscarPorIdPelicula(Integer id) {
		return personajeRepository.buscarPorIdPelicula(id);
	}

	
	@Override
	@Transactional()	
	public void editarPersonajeById(Integer id, Personaje personaje) {
		
		if(personaje.getNombre() != null) {
			personajeRepository.findById(id).orElse(null).setNombre(personaje.getNombre());;
		}
		if(personaje.getHistoria() != null) {
			personajeRepository.findById(id).orElse(null).setHistoria(personaje.getHistoria());;
		}
		if(personaje.getEdad() != null) {
			personajeRepository.findById(id).orElse(null).setEdad(personaje.getEdad());;
		}
		if(personaje.getPeso() != null) {
			personajeRepository.findById(id).orElse(null).setPeso(personaje.getPeso());;
		}
		if(personaje.getPeliculas() != null) {
			personajeRepository.findById(id).orElse(null).setPeliculas(personaje.getPeliculas());;
		}
		if(personaje.getImagen() != null) {
			personajeRepository.findById(id).orElse(null).setImagen(personaje.getImagen());;
		}
		
		personajeRepository.save(personajeRepository.findById(id).orElse(null));
		
	}

}
