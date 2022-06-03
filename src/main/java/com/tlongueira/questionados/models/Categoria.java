package com.tlongueira.questionados.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nombre;
	
	@JsonManagedReference
	@OneToMany(mappedBy ="categoria")
	private Set<Pregunta> preguntas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Categoria(Long id, @NotBlank String nombre, Set<Pregunta> preguntas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.preguntas = preguntas;
	}

	public Categoria() {
		super();
	}
	
	
}
