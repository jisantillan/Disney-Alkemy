package com.alkemy.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alkemy.models.Personaje;
import com.alkemy.service.PersonajeService;



@RestController
@RequestMapping("/characters")
public class CharacterRestController {
	@Autowired
	private PersonajeService personajeServicio;

	//	POST METHOD
	
	@PostMapping("/guardar")
	public void guardar( @RequestPart(value = "imagen_personaje", required = false) MultipartFile image,@RequestPart("json_personaje") Personaje personaje) {
		if(!(image==null)) {
			procesarimagen(image, personaje);
		}
		personajeServicio.guardar(personaje) ;
	}
	

	private void procesarimagen(MultipartFile image, Personaje personaje) {
		if(!image.isEmpty()){
			Path imagesPath = Paths.get("src//main//resources//static//images");
			String absolutPath = imagesPath.toFile().getAbsolutePath();
			try {
				byte[] bytes = image.getBytes();
				Path route = Paths.get(absolutPath + image.getOriginalFilename());
				Files.write(route, bytes);
				personaje.setImagen((image.getOriginalFilename()));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//	PUT METHOD
	
	@PutMapping("/editar/{id}")
	public  void editarPersonaje(@PathVariable("id") Integer id, @RequestPart(value = "imagen_personaje", required = false) MultipartFile image,@RequestPart("json_personaje") Personaje personaje) {
		if(!(image==null)) {
			procesarimagen(image, personaje);
		}
		personajeServicio.editarPersonajeById(id, personaje);
	}
	
	//	GET METHODS

	@GetMapping()
	public Iterable<Object[]> listar() {
		return personajeServicio.listarPersonajes();
	}

	@GetMapping(path = "/{id}")
	public Personaje detalle(@PathVariable("id") Integer id){
		return personajeServicio.listarPorId(id);

	}
	
	//	DELETE METHOD

	@DeleteMapping(path = "delete/{id}")
	public String delete(@PathVariable("id") Integer id){
		try {
			personajeServicio.eliminar(id);
			return "Personaje "+ id +" eliminado con exito";
		} catch (Exception e) {
			return "Error eliminando el personaje"+ id ;
		}
	}

	// FILTERS

	@GetMapping(params="name")
	public Iterable<Object[]> listarPorNombre(@RequestParam("name") String name){
		return personajeServicio.buscarPorNombre(name);
	}

	@GetMapping(params="age")
	public Iterable<Object[]> listarPorEdad(@RequestParam("age") Integer age){
		return personajeServicio.buscarPorEdad(age);
	}

	@GetMapping(params="movies")
	public Iterable<Object[]> listarPorId(@RequestParam("movies") Integer movies){
		return personajeServicio.buscarPorIdPelicula(movies);
	}



}






