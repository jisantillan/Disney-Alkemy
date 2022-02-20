package com.alkemy.service;


import com.alkemy.entity.Personaje;

public interface PersonajeService {
	
	public Iterable<Object[]> listarPersonajes();
	public Iterable<Object[]> buscarPorNombre(String nombre);
	public Iterable<Object[]> buscarPorEdad(Integer edad);
	public Iterable<Object[]> buscarPorIdPelicula(Integer id);

	public void guardar (Personaje personaje);
	public void editarPersonajeById(Integer id, Personaje personaje);
	public void eliminar(Integer id);
	public Personaje listarPorId(Integer id);
	
}
