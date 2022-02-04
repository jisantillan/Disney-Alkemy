package com.alkemy.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="personaje")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Personaje {


@GeneratedValue(strategy = GenerationType.IDENTITY)

@Id
private Integer id;


private String nombre;

private String imagen;

private Integer edad;

private Float peso;

private String historia;

@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
@JoinTable(
        name = "personaje_pelicula",
        joinColumns = @JoinColumn(name = "id_personaje"),
        inverseJoinColumns = @JoinColumn(name="id_pelicula")
    )
@JsonIgnoreProperties("personajes")
private List <Pelicula> peliculas ;

public List<Pelicula> getPeliculas() {
	return peliculas;
}

public void setPeliculas(List<Pelicula> peliculas) {
	this.peliculas = peliculas;
}


}







