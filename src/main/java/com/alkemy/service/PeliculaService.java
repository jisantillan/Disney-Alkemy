package com.alkemy.service;


import com.alkemy.models.Pelicula;

public interface PeliculaService {
	
	public Iterable<Object[]> listarPeliculas();
	public Iterable<Object[]> buscarPorNombre(String nombre);
	public Iterable<Object[]> buscarPorGenero(Integer id_genero);
	public Iterable <Object[]> listarPorOrden (String string);
	public void editarPeliculaById(Integer id, Pelicula pelicula);
	public void guardar (Pelicula pelicula);
	public Pelicula getPelicula(Integer id);
	public void eliminar(Integer id);
}
