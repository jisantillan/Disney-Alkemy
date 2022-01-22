package com.alkemy.service;

import java.util.List;

import com.alkemy.models.Personaje;

public interface PersonajeService {
	
	public List<Personaje> listarPersonajes();
	public void guardar (Personaje personaje);
	public void actualizar (Personaje personaje);
	public Personaje getPersonaje(Integer id);
	public void eliminar(Integer id);
	
}
