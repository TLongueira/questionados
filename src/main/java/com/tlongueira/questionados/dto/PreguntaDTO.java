package com.tlongueira.questionados.dto;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PreguntaDTO {

private String descripcion;
private Long categoria_id;

@Size(min = 4, max=4)
@NotNull
private Set<RespuestaDTO> respuestas;


public PreguntaDTO(String descripcion, Long categoria_id, @Size(min = 4, max = 4) Set<RespuestaDTO> respuestas) {
	super();
	this.descripcion = descripcion;
	this.categoria_id = categoria_id;
	this.respuestas = respuestas;
}
public Set<RespuestaDTO> getRespuestas() {
	return respuestas;
}
public void setRespuestas(Set<RespuestaDTO> respuestas) {
	this.respuestas = respuestas;
}
public Long getCategoria_id() {
	return categoria_id;
}
public void setCategoria_id(Long categoria_id) {
	this.categoria_id = categoria_id;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


public PreguntaDTO() {
	super();
}


}
