package com.alkemy.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pelicula")
@ToString @EqualsAndHashCode
@Data
@NoArgsConstructor
public class Pelicula {

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Id
	private Integer id;

	private String titulo;

	private Date fecha;

	private Integer calificacion;

	private String imagen;

	@ManyToMany(fetch=FetchType.LAZY, mappedBy = "peliculas" )
	@JsonIgnoreProperties("peliculas")
	private List <Personaje> personajes;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name="id_genero")
	@JsonBackReference
	public Genero genero; 

	public List<Personaje> getPersonajes() {
		return personajes;
	}
	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}


}








