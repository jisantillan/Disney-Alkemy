package com.alkemy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.models.Pelicula;
import com.alkemy.service.PeliculaService;

@RestController
@RequestMapping("/movies")
public class PeliculaRestController {
	@Autowired
	private PeliculaService peliculaServicio;
	



	@PostMapping("/guardar")
	public void guardar( @RequestBody Pelicula pelicula) {
		 
		peliculaServicio.guardar(pelicula) ;
	}
	
//	
	
	@GetMapping()
	public List<Pelicula> listar() {
		return peliculaServicio.listarPelicula();
	}
	
//	@GetMapping()
//	public Iterable<Object[]> listar() {
//		return peliculaServicio.listarPelicula();
//	}
//	
//	@GetMapping(path = "/{id}")
//    public Personaje detalle(@PathVariable("id") Integer id){
//       return peliculaServicio.listarPorId(id);
//      
//    }
//	
//	@GetMapping(params="name")
//    public Iterable<Object[]> listarPorNombre(@RequestParam("name") String name){
//        return peliculaServicio.buscarPorNombre(name);
//    }
//	
//    @GetMapping(params="age")
//    public Iterable<Object[]> listarPorEdad(@RequestParam("age") Integer age){
//        return peliculaServicio.buscarPorEdad(age);
//    }
//    
//    @GetMapping(params="movies")
//    public Iterable<Object[]> listarPorId(@RequestParam("movies") Integer movies){
//        return peliculaServicio.buscarPorIdPelicula(movies);
//    }
    
	@DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        try {
        	
        	peliculaServicio.eliminar(id);
            return "Personaje "+ id +" eliminado con exito";
        } catch (Exception e) {
            return "Error eliminando el personaje"+ id ;
        }
    }
}
