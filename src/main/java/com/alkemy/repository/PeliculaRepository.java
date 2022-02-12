package com.alkemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alkemy.models.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
	
		@Query(value = "SELECT imagen,titulo,fecha FROM Pelicula")	    
	    public Iterable<Object[]> listar();
	    
	    @Query(value = "SELECT p.imagen,p.titulo,p.fecha FROM Pelicula p WHERE p.titulo = ?1")
	    public Iterable<Object[]> buscarPorNombre( String filtro);

}
