package com.alkemy.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;





@Entity
@Table(name="personaje")
@ToString @EqualsAndHashCode
public class Personaje {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Getter @Setter @Column(name="id_personaje")
private Integer id;

@Getter @Setter @Column(name="nombre")
private String nombre;

@Getter @Setter @Column(name="imagen")
private String imagen;

@Getter @Setter @Column(name="edad")
private Integer edad;

@Getter @Setter @Column(name="peso")
private Float peso;

@Getter @Setter @Column(name="historia")
private String historia;

@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
@JoinTable(
        name = "personaje_pelicula",
        joinColumns = @JoinColumn(name = "id_personaje"),
        inverseJoinColumns = @JoinColumn(name="id_pelicula")
    )
private List <Pelicula> peliculas ;

public List<Pelicula> getPeliculas() {
	return peliculas;
}

public void setPeliculas(List<Pelicula> peliculas) {
	this.peliculas = peliculas;
}


}







