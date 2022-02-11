package com.alkemy.service;

import java.util.List;

import com.alkemy.models.Pelicula;

public interface PeliculaService {
	public List<Pelicula> listarPelicula();
	public void guardar (Pelicula pelicula);
	public void actualizar (Pelicula pelicula);
	public Pelicula getPelicula(Pelicula pelicula);
	public void eliminar(Integer id);
}
