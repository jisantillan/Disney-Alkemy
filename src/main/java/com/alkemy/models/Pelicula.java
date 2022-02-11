package com.alkemy.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pelicula")
@ToString @EqualsAndHashCode
public class Pelicula {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter @Column(name="id_pelicula")
	private Integer id;

	@Getter @Setter @Column(name="titulo")
	private String titulo;

	@Getter @Setter @Column(name="fecha")
	private Date fecha;

	@Getter @Setter @Column(name="calificacion")
	private Integer calificacion;

	@Getter @Setter @Column(name="imagen")
	private String imagen;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy = "peliculas" )
	@JsonIgnoreProperties("peliculas")
	private List <Personaje> personajes;

	
    @OneToMany(mappedBy="pelicula")
    public List <Genero> generos; 
    

	public List<Personaje> getPersonajes() {
		return personajes;
	}
    public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}
	public List<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
    


}








