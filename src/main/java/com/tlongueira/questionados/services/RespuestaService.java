package com.tlongueira.questionados.services;

import java.util.List;

import com.tlongueira.questionados.dto.RespuestaDTO;
import com.tlongueira.questionados.models.Respuesta;

public interface RespuestaService {
	
	public Respuesta crearRespuesta(RespuestaDTO respuestaDTO);

	public Respuesta obtenerPorId(Long id);

	public List<Respuesta> obtenerTodas();

}
