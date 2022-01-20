package com.alkemy.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String nombre;

	@Getter @Setter @Column(name="fecha")
	private Date fecha;

	@Getter @Setter @Column(name="calificación")
	private Integer calificación;

	@Getter @Setter @Column(name="imagen")
	private String imagen;

}








