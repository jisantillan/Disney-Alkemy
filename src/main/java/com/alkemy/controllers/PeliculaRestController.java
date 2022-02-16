package com.alkemy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@GetMapping()
	public Iterable<Object[]> listar() {
		return peliculaServicio.listarPeliculas();
	}
	
	@GetMapping(path = "/{id}")
    public Pelicula detalle(@PathVariable("id") Integer id){
       return peliculaServicio.getPelicula(id);     
    }
	
	@GetMapping(params="name")
    public Iterable<Object[]> listarPorNombre(@RequestParam("name") String name){
        return peliculaServicio.buscarPorNombre(name);
    }
    @GetMapping(params="genre")
    public Iterable<Object[]> listarPorEdad(@RequestParam("genre") Integer genre){
        return peliculaServicio.buscarPorGenero(genre);
    }
    
    @GetMapping(params="order")
    public Iterable<Object[]> listarPorId(@RequestParam("order") String orden){
        return peliculaServicio.listarPorOrden(orden);
    }
    
	@DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        try {        	
        	peliculaServicio.eliminar(id);
            return "La pelicula con ID:  "+ id +"  fue eliminada con exito";
        } catch (Exception e) {
            return "Error eliminando la pelicula con ID: "+ id ;
        }
    }
}
