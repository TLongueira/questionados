package com.tlongueira.questionados.dto;

public class RespuestaUsuarioDTO {
	
	private Long idPregunta;
	private Long idRespuesta;
	public Long getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}
	public Long getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(Long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public RespuestaUsuarioDTO(Long idPregunta, Long idRespuesta) {
		super();
		this.idPregunta = idPregunta;
		this.idRespuesta = idRespuesta;
	}
	public RespuestaUsuarioDTO() {
		super();
	}
	
	

}
