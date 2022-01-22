package com.alkemy.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alkemy.models.Personaje;
import com.alkemy.service.PersonajeService;



@RestController
@RequestMapping("/characters")
public class CharacterRestController {
	@Autowired
	private PersonajeService personajeServicio;
	

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}


	@PostMapping("/guardar")
	public void guardar( @RequestBody Personaje personaje) {
		 
		 personajeServicio.guardar(personaje) ;
	}
	
//	
	
	@GetMapping(value = "/listar")
	public List<Personaje> listar() {
		return personajeServicio.listarPersonajes();
	}
	
	@DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        try {
            personajeServicio.eliminar(id);
            return "Personaje"+ id +" eliminado con exito";
        } catch (Exception e) {
            return "Error eliminando el personaje"+ id ;
        }
    }
}





	
