package com.alkemy.service;

import java.util.List;

import com.alkemy.entity.Genero;

public interface GeneroService {
	
	public void guardar (Genero genero);
	public List<Genero> listar ();
	public Genero getPelicula(Integer id);
	public void eliminar(Integer id);
}
