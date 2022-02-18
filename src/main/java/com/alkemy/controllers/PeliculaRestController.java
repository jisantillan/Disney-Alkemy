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

import com.alkemy.models.Pelicula;
import com.alkemy.service.PeliculaService;

@RestController
@RequestMapping("/movies")
public class PeliculaRestController {
	@Autowired
	private PeliculaService peliculaServicio;

	// POST METHOD

	@PostMapping("/guardar")
	public ResponseEntity<String> guardar( @RequestPart(value = "imagen_pelicula", required = false) MultipartFile image,@RequestPart("json_pelicula") Pelicula pelicula) {
		if(!(image==null)) {
			procesarimagen(image, pelicula);
		}
		peliculaServicio.guardar(pelicula) ;
		return ResponseEntity.status(HttpStatus.CREATED).body("Pelicula creada con exito");
	}

	private void procesarimagen(MultipartFile image, Pelicula pelicula) {
		if(!image.isEmpty()){
			Path imagesPath = Paths.get("src//main//resources//static//images");
			String absolutPath = imagesPath.toFile().getAbsolutePath();
			try {
				byte[] bytes = image.getBytes();
				Path route = Paths.get(absolutPath + image.getOriginalFilename());
				Files.write(route, bytes);
				pelicula.setImagen((image.getOriginalFilename()));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//	PUT METHOD

	@PutMapping("/editar/{id}")
	public  ResponseEntity<Void> editarPelicula(@PathVariable("id") Integer id, @RequestPart(value = "imagen_personaje", required = false) MultipartFile image,@RequestPart("json_pelicula") Pelicula pelicula) {
		if(!(image==null)) {
			procesarimagen(image, pelicula);
		}
		peliculaServicio.editarPeliculaById(id, pelicula);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}


	//	GET METHODS


	@GetMapping()
	public ResponseEntity<Iterable<Object[]>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.listarPeliculas());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Pelicula> detalle(@PathVariable("id") Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.getPelicula(id));
	}

	//	DELETE METHOD

	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		peliculaServicio.eliminar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	//	FILTERS

	@GetMapping(params="name")
	public ResponseEntity<Iterable<Object[]>> listarPorNombre(@RequestParam("name") String name){
		return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.buscarPorNombre(name));
	}
	
	@GetMapping(params="genre")
	public ResponseEntity<Iterable<Object[]>> listarPorEdad(@RequestParam("genre") Integer genre){
		return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.buscarPorGenero(genre));
	}

	@GetMapping(params="order")
	public ResponseEntity<Iterable<Object[]>> listarPorOrden(@RequestParam("order") String orden){
		return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.listarPorOrden(orden));
	}


}
