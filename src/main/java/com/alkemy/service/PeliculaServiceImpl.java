package com.alkemy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.models.Pelicula;
import com.alkemy.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService {

	@Autowired
	private PeliculaRepository peliculaDao;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Object[]> listarPeliculas() {
		Iterable<Object[]>peliculas = peliculaDao.listar();
		return peliculas;	}

	
	@Override
	@Transactional
	public void guardar(Pelicula pelicula) {
		peliculaDao.save(pelicula);
	}

	@Override
	public Pelicula getPelicula(Integer id) {
		return peliculaDao.findById(id).orElse(null);
	}


	@Override
	public void eliminar(Integer id) {
		peliculaDao.deleteById(id);
	}
	
	

	@Override
	public Iterable<Object[]> buscarPorNombre(String nombre) {
		return peliculaDao.buscarPorNombre(nombre);
	}



	@Override
	public Iterable<Object[]> buscarPorGenero(Integer id_genero) {
		return peliculaDao.buscarPorGenero(id_genero);
	}



	@Override
	public Iterable<Object[]> listarPorOrden(String orden) {
		if(orden.equals("ASC")){
			return peliculaDao.listarOrdenAsc();            
		}else if(orden.equals("DESC")){
			return peliculaDao.listarOrdenDesc();  
		}
		return null;
	}



	@Override
	@Transactional
	public void editarPeliculaById(Integer id, Pelicula pelicula) {
		
		if(pelicula.getTitulo() != null) {
			peliculaDao.findById(id).orElse(null).setTitulo(pelicula.getTitulo());;
		}
		if(pelicula.getCalificacion() != null) {
			peliculaDao.findById(id).orElse(null).setCalificacion(pelicula.getCalificacion());;
		}
		if(pelicula.getPersonajes() != null) {
			peliculaDao.findById(id).orElse(null).setPersonajes(pelicula.getPersonajes());;
		}
		if(pelicula.getCalificacion() != null) {
			peliculaDao.findById(id).orElse(null).setCalificacion(pelicula.getCalificacion());;
		}
		if(pelicula.getFecha() != null) {
			peliculaDao.findById(id).orElse(null).setFecha(pelicula.getFecha());;
		}
		if(pelicula.getImagen() != null) {
			peliculaDao.findById(id).orElse(null).setImagen(pelicula.getImagen());;
		}
		peliculaDao.save(peliculaDao.findById(id).orElse(null));		
	}

}






