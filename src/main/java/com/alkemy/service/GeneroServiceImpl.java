package com.alkemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.entity.Genero;
import com.alkemy.repository.GeneroRepository;

@Service
public class GeneroServiceImpl implements GeneroService{

	@Autowired 
	GeneroRepository generoRepository ;
	
	@Override
	public void guardar(Genero genero) {
		generoRepository.save(genero);
		
	}

	@Override
	public List<Genero> listar() {
		return generoRepository.findAll();
	}
	@Override
	public Genero getPelicula(Integer id) {
		return generoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		generoRepository.deleteById(id);
	}
	
}
