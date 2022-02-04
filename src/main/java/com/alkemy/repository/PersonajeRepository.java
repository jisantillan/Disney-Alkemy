package com.alkemy.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alkemy.models.Personaje;

public interface PersonajeRepository extends JpaRepository<Personaje, Integer >{
	
    @Query(value = "SELECT nombre,imagen FROM Personaje")	    
    public Iterable<Object[]> listar();
    
    @Query(value = "SELECT p.nombre,p.imagen FROM Personaje p WHERE p.nombre = ?1")
    public Iterable<Object[]> buscarPorNombre( String filtro);
    
    @Query(value = "SELECT p.nombre,p.imagen FROM Personaje p WHERE p.edad = ?1")
    public Iterable<Object[]> buscarPorEdad( Integer filtro);
    
    @Query (value = "SELECT p.nombre, p.imagen\r\n"
    		+ "FROM personaje as p\r\n"
    		+ "WHERE p.id =\r\n"
    		+ "(SELECT personaje_pelicula.id_personaje\r\n"
    		+ "FROM personaje_pelicula\r\n"
    		+ "WHERE personaje_pelicula.id_personaje = ?1)", nativeQuery= true)
    public Iterable<Object[]> buscarPorIdPelicula(Integer id);

}

