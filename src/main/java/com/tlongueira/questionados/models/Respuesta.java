package com.tlongueira.questionados.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "respuestas")
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String descripcion;
	
	@NotBlank
	private Boolean esCorrecta;
	
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name="pregunta_id", nullable=false)
    private Pregunta pregunta;

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

	public Boolean getEsCorrecta() {
		return esCorrecta;
	}

	public void setEsCorrecta(Boolean esCorrecta) {
		this.esCorrecta = esCorrecta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Respuesta(Long id, @NotBlank String descripcion, @NotBlank Boolean esCorrecta, Pregunta pregunta) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.esCorrecta = esCorrecta;
		this.pregunta = pregunta;
	}

	public Respuesta() {
		super();
	}
	
	

}
