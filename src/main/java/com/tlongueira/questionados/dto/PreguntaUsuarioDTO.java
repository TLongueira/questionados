package com.tlongueira.questionados.dto;

import java.util.Set;

public class PreguntaUsuarioDTO {

	private Long id;

	private String descripcion;

	private Set<RespuestaDTO> respuestas;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}





	public PreguntaUsuarioDTO(Long id, String descripcion, Set<RespuestaDTO> respuestas) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.respuestas = respuestas;
	}

	public Set<RespuestaDTO> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<RespuestaDTO> respuestas) {
		this.respuestas = respuestas;
	}

	public PreguntaUsuarioDTO() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
