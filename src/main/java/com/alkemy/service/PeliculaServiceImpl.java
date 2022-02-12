package com.alkemy.service;

import java.util.List;

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
	@Transactional
	public void actualizar(Pelicula pelicula) {
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
	
	


	
}
