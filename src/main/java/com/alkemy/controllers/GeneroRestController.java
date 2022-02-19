package com.alkemy.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alkemy.models.Genero;
import com.alkemy.service.GeneroService;


@RestController
@RequestMapping("/genre")
public class GeneroRestController {
	@Autowired
	private GeneroService generoServicio;

	// POST METHOD

	@PostMapping("/guardar")
	public ResponseEntity<String> guardar( @RequestPart(value = "imagen_genero", required = false) MultipartFile image,@RequestPart("json_genero") Genero genero) {
		if(!(image==null)) {
			procesarimagen(image, genero);
		}
		generoServicio.guardar(genero) ;
		return ResponseEntity.status(HttpStatus.CREATED).body("Genero creado con exito");
	}

	private void procesarimagen(MultipartFile image, Genero genero) {
		if(!image.isEmpty()){
			Path imagesPath = Paths.get("src//main//resources//static//images");
			String absolutPath = imagesPath.toFile().getAbsolutePath();
			try {
				byte[] bytes = image.getBytes();
				Path route = Paths.get(absolutPath + image.getOriginalFilename());
				Files.write(route, bytes);
				genero.setImagen((image.getOriginalFilename()));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	//	GET METHODS


	@GetMapping()
	public ResponseEntity<List<Genero>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(generoServicio.listar());
	}

	//	DELETE METHOD

	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		generoServicio.eliminar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	

}
