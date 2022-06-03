package com.tlongueira.questionados.dto;

public class RespuestaDTO {
private String descripcion;
private Boolean esCorrecta;
private Long respuestaId;
private Long pregunta_id;
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

public RespuestaDTO() {
	super();
}
public Long getRespuestaId() {
	return respuestaId;
}
public void setRespuestaId(Long respuestaId) {
	this.respuestaId = respuestaId;
}
public Long getPregunta_id() {
	return pregunta_id;
}
public void setPregunta_id(Long pregunta_id) {
	this.pregunta_id = pregunta_id;
}
public RespuestaDTO(String descripcion, Boolean esCorrecta, Long respuestaId, Long pregunta_id) {
	super();
	this.descripcion = descripcion;
	this.esCorrecta = esCorrecta;
	this.respuestaId = respuestaId;
	this.pregunta_id = pregunta_id;
}




}
