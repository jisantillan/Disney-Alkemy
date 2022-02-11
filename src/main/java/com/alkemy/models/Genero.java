package com.alkemy.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="genero")
@ToString @EqualsAndHashCode
public class Genero {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter 
	private Integer id_genero;

	@Getter @Setter 
	private String nombre;

	@Getter @Setter 
	private String imagen;
	
	 @ManyToOne
	 @JoinColumn(name="id_pelicula", nullable=false)
	 private Pelicula pelicula;
	 
	 




   

}