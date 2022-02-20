package com.alkemy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.entity.Pelicula;
import com.alkemy.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService {

	@Autowired
	private PeliculaRepository peliculaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Object[]> listarPeliculas() {
		Iterable<Object[]>peliculas = peliculaRepository.listar();
		return peliculas;	}

	
	@Override
	@Transactional
	public void guardar(Pelicula pelicula) {
		peliculaRepository.save(pelicula);
	}

	@Override
	public Pelicula getPelicula(Integer id) {
		return peliculaRepository.findById(id).orElse(null);
	}


	@Override
	public void eliminar(Integer id) {
		peliculaRepository.deleteById(id);
	}
	
	

	@Override
	public Iterable<Object[]> buscarPorNombre(String nombre) {
		return peliculaRepository.buscarPorNombre(nombre);
	}



	@Override
	public Iterable<Object[]> buscarPorGenero(Integer id_genero) {
		return peliculaRepository.buscarPorGenero(id_genero);
	}



	@Override
	public Iterable<Object[]> listarPorOrden(String orden) {
		if(orden.equals("ASC")){
			return peliculaRepository.listarOrdenAsc();            
		}else if(orden.equals("DESC")){
			return peliculaRepository.listarOrdenDesc();  
		}
		return null;
	}



	@Override
	@Transactional
	public void editarPeliculaById(Integer id, Pelicula pelicula) {
		
		if(pelicula.getTitulo() != null) {
			peliculaRepository.findById(id).orElse(null).setTitulo(pelicula.getTitulo());;
		}
		if(pelicula.getCalificacion() != null) {
			peliculaRepository.findById(id).orElse(null).setCalificacion(pelicula.getCalificacion());;
		}
		if(pelicula.getPersonajes() != null) {
			peliculaRepository.findById(id).orElse(null).setPersonajes(pelicula.getPersonajes());;
		}
		if(pelicula.getFecha() != null) {
			peliculaRepository.findById(id).orElse(null).setFecha(pelicula.getFecha());;
		}
		if(pelicula.getImagen() != null) {
			peliculaRepository.findById(id).orElse(null).setImagen(pelicula.getImagen());;
		}
		peliculaRepository.save(peliculaRepository.findById(id).orElse(null));		
	}

}






