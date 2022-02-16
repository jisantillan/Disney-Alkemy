package com.alkemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alkemy.models.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
	
		@Query(value = "SELECT imagen,titulo,fecha FROM Pelicula")	    
	    public Iterable<Object[]> listar();
	    
	    @Query(value = "SELECT p.imagen,p.titulo,p.fecha FROM Pelicula p WHERE p.titulo = ?1")
	    public Iterable<Object[]> buscarPorNombre( String filtro);
	    
	    @Query (value = "SELECT  p.imagen,p.titulo,p.fecha FROM pelicula as p WHERE p.id_genero = ?1" , nativeQuery= true)
	    public Iterable<Object[]> buscarPorGenero( Integer id_genero);

	    @Query(value = "SELECT  p.imagen,p.titulo,p.fecha FROM pelicula as p ORDER BY p.fecha ASC",nativeQuery = true)
	    public Iterable<Object[]> listarOrdenAsc();

	    @Query(value = "SELECT  p.imagen,p.titulo,p.fecha FROM pelicula as p ORDER BY p.fecha DESC",nativeQuery = true)
	    public Iterable<Object[]> listarOrdenDesc();
}
