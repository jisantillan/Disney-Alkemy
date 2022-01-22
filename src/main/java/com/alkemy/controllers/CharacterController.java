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

import com.alkemy.models.Personaje;
import com.alkemy.repository.PersonajeRepository;
import com.alkemy.service.PeliculaService;
import com.alkemy.service.PersonajeService;

@Controller
@RequestMapping("/vista")
public class CharacterController{
	
	@Autowired
	private PersonajeService personaServicio;
	
	@Autowired
	private PeliculaService peliculaServicio;

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/modificar")
	public String agregar(Model model) {
		model.addAttribute("personaje", new Personaje());
		model.addAttribute("peliculas", peliculaServicio.listarPelicula());
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
	

	

}
