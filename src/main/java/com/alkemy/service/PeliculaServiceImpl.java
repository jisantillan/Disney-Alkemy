package com.alkemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.dao.PeliculaDao;
import com.alkemy.models.Pelicula;

@Service
public class PeliculaServiceImpl implements PeliculaService {

	@Autowired
	private PeliculaDao peliculaDao;

	@Override
	public List<Pelicula> listarPelicula() {
		
		return peliculaDao.findAll();
	}

	@Override
	public void guardar(Pelicula pelicula) {

		peliculaDao.save(pelicula);
	}

	@Override
	public void actualizar(Pelicula pelicula) {
		peliculaDao.save(pelicula);
		
	}

	@Override
	public Pelicula getPelicula(Pelicula pelicula) {
		return peliculaDao.findById(pelicula.getId()).orElse(null);
	}

	@Override
	public void eliminar(Pelicula pelicula) {
		peliculaDao.deleteById(pelicula.getId());
	}
	
	


	
}
