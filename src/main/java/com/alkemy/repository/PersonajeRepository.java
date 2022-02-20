package com.alkemy.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alkemy.entity.Personaje;

public interface PersonajeRepository extends JpaRepository<Personaje, Integer >{
	
    @Query(value = "SELECT nombre,imagen FROM Personaje")	    
    public Iterable<Object[]> listar();
    
    @Query(value = "SELECT p.nombre,p.imagen FROM Personaje p WHERE p.nombre = ?1")
    public Iterable<Object[]> buscarPorNombre( String filtro);
    
    @Query(value = "SELECT p.nombre,p.imagen FROM Personaje p WHERE p.edad = ?1")
    public Iterable<Object[]> buscarPorEdad( Integer filtro);
    
    @Query (value = "SELECT p.nombre, p.imagen FROM personaje as p WHERE p.id IN (SELECT personaje_pelicula.id_personaje FROM personaje_pelicula WHERE personaje_pelicula.id_pelicula = ?1)", nativeQuery= true)
    public Iterable<Object[]> buscarPorIdPelicula(Integer id);

}

