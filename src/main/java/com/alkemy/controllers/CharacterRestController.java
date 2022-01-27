package com.alkemy.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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





	
