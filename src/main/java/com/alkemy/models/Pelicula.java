package com.alkemy.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

//    @OneToMany(mappedBy="pelicula")

//    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    
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








