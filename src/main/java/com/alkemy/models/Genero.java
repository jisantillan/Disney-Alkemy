package com.alkemy.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
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
	
	@OneToMany(mappedBy = "genero",fetch=FetchType.LAZY, cascade = CascadeType.MERGE)	
	@JsonManagedReference
	private List <Pelicula> films;
	 
	 




   

}