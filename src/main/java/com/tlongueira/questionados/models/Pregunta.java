package com.tlongueira.questionados.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "preguntas")
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String descripcion;
	
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name="categoria_id", nullable=false)
    private Categoria categoria;
	
	@JsonManagedReference
	@OneToMany(mappedBy ="pregunta")
	@Size(min = 4, max=4)
	private Set<Respuesta> respuestas;
	
	

	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Pregunta(Long id, @NotBlank String descripcion, Categoria categoria) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.categoria = categoria;
	}

	public Pregunta() {
		super();
	}
    
    
}
