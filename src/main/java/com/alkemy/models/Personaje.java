package com.alkemy.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="personaje")
@ToString @EqualsAndHashCode
public class Personaje {

@Id
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

@Getter @Setter @Column(name="id_pelicula")
private Integer peliculas;


}
