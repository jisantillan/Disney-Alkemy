package com.alkemy.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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

	@Getter @Setter @Column(name="calificación")
	private Integer calificación;

	@Getter @Setter @Column(name="imagen")
	private String imagen;
	
   @JoinTable(
	        name = "personaje_pelicula",
	        joinColumns = @JoinColumn(name = "id_pelicula", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="id_personaje", nullable = false)
	    )
	@ManyToMany
	private List <Personaje> personajes;

}








