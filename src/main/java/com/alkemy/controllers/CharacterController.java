package com.alkemy.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.dao.PersonajeDao;
import com.alkemy.models.Personaje;
import com.alkemy.service.PersonajeService;

@Controller
@RequestMapping("/characters")
public class CharacterController{
	
	@Autowired
	private PersonajeService personaServicio;
	
//	@RequestMapping(value = "characters/{id}" , method = RequestMethod.GET)
//	public Personaje getPersonaje(@PathVariable String id) {
//		Personaje personaje = new Personaje ();
//		personaje.setNombre("javier");
//		return personaje;
//	}
//	
//	@RequestMapping(value = "modificarpersonaje", method = RequestMethod.POST)
//	public Personaje modificarPersonaje() {
//		Personaje personaje = new Personaje ();
//		personaje.setNombre("Javier");
//		return personaje;
//	}
//	
//	@RequestMapping(value = "delete/characters/{id}", method = RequestMethod.DELETE)
//	public  void eliminarPersonaje(@PathVariable Integer id ) {
//		
//		 characterDao.delete(id);
//	}
	
//	@RequestMapping(value = "personajes")
//	public Character listarPersonajes() {
//		Character personaje = new Character ();
//		personaje.setNombre("javier");
//		return personaje;
//	}
	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/modificar")
	public String agregar(Model model) {
		model.addAttribute("personaje", new Personaje());
		return "formPersonaje";
	}
	
	@PostMapping("/guardar")
	public String guardar( Personaje personaje) {
		
		personaServicio.guardar(personaje);
		return "redirect:/";
	}
	
	@GetMapping(value = "/listar")
	public List<Personaje> listar() {
		return personaServicio.listarPersonajes();
	}
	
//	@GetMapping(value = "detalle/{id}")
//	public Optional<Personaje> listarPorId(@PathVariable Integer id) {
//		return personaServicio.getPersonaje(id);
//	}
//	
//	@DeleteMapping (value = "delete/{id}")
//	public void borrar(@PathVariable Integer id) {
//		characterDao.deleteById(id);
//	}
//	
//	@PutMapping (value ="actualizar")
//	public void actualizar(@RequestBody Personaje personaje) {
//		characterDao.save(personaje);
//	}
	
	

}
