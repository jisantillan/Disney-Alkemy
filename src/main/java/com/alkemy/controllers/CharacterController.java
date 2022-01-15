package com.alkemy.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.dao.characterDao;
import com.alkemy.models.Personaje;

@RestController
public class CharacterController{
	
	@Autowired
	private characterDao characterDao;
	
	@RequestMapping(value = "characters/{id}" , method = RequestMethod.GET)
	public Personaje getPersonaje(@PathVariable String id) {
		Personaje personaje = new Personaje ();
		personaje.setNombre("javier");
		return personaje;
	}
	
	@RequestMapping(value = "modificarpersonaje", method = RequestMethod.POST)
	public Personaje modificarPersonaje() {
		Personaje personaje = new Personaje ();
		personaje.setNombre("Javier");
		return personaje;
	}
	
	@RequestMapping(value = "delete/characters/{id}", method = RequestMethod.DELETE)
	public  void eliminarPersonaje(@PathVariable Integer id ) {
		
		 characterDao.delete(id);
	}
	
//	@RequestMapping(value = "personajes")
//	public Character listarPersonajes() {
//		Character personaje = new Character ();
//		personaje.setNombre("javier");
//		return personaje;
//	}

	@RequestMapping(value = "characters")
	public List<Personaje> getUsuarios() {
		return characterDao.getUsuarios();
	}
	
	
	

}
