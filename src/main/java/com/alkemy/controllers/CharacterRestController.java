package com.alkemy.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> guardar( @RequestPart(value = "imagen_personaje", required = false) MultipartFile image,@RequestPart("json_personaje") Personaje personaje) {
		if(!(image==null)) {
			procesarimagen(image, personaje);
		}
		personajeServicio.guardar(personaje) ;
		return ResponseEntity.status(HttpStatus.CREATED).body("Personaje creado con exito");
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
	public ResponseEntity<Void> editarPersonaje(@PathVariable("id") Integer id, @RequestPart(value = "imagen_personaje", required = false) MultipartFile image,@RequestPart("json_personaje") Personaje personaje) {
		if(!(image==null)) {
			procesarimagen(image, personaje);
		}
		personajeServicio.editarPersonajeById(id, personaje);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}
	
	//	GET METHODS

	@GetMapping()
	public ResponseEntity<Iterable<Object[]>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(personajeServicio.listarPersonajes());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Personaje> detalle(@PathVariable("id") Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(personajeServicio.listarPorId(id));
	}
	
	//	DELETE METHOD
	
	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		personajeServicio.eliminar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	// FILTERS

	@GetMapping(params="name")
	public ResponseEntity<Iterable<Object[]>> listarPorNombre(@RequestParam("name") String name){
		return ResponseEntity.status(HttpStatus.OK).body(personajeServicio.buscarPorNombre(name));
	}

	@GetMapping(params="age")
	public ResponseEntity<Iterable<Object[]>> listarPorEdad(@RequestParam("age") Integer age){
		return ResponseEntity.status(HttpStatus.OK).body(personajeServicio.buscarPorEdad(age));
	}

	@GetMapping(params="movies")
	public ResponseEntity<Iterable<Object[]>> listarPorId(@RequestParam("movies") Integer movies){
		return ResponseEntity.status(HttpStatus.OK).body(personajeServicio.buscarPorIdPelicula(movies));
	}



}






