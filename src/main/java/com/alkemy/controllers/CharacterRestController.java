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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alkemy.models.Personaje;
import com.alkemy.service.PersonajeService;



@RestController
@RequestMapping("/characters")
public class CharacterRestController {
	@Autowired
	private PersonajeService personajeServicio;
	



	@PostMapping("/guardar")
	public void guardar( @RequestBody Personaje personaje) {
		 
		 personajeServicio.guardar(personaje) ;
	}
	
//	
	
	@GetMapping()
	public Iterable<Object[]> listar() {
		return personajeServicio.listarPersonajes();
	}
	
	@GetMapping(path = "/{id}")
    public Personaje detalle(@PathVariable("id") Integer id){
       return personajeServicio.listarPorId(id);
      
    }
	
	@GetMapping(params="name")
    public Iterable<Object[]> listarPorNombre(@RequestParam("name") String name){
        return personajeServicio.buscarPorNombre(name);
    }
	
    @GetMapping(params="age")
    public Iterable<Object[]> listarPorEdad(@RequestParam("age") Integer age){
        return personajeServicio.buscarPorEdad(age);
    }
    
	@DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        try {
            personajeServicio.eliminar(id);
            return "Personaje "+ id +" eliminado con exito";
        } catch (Exception e) {
            return "Error eliminando el personaje"+ id ;
        }
    }
}





	
