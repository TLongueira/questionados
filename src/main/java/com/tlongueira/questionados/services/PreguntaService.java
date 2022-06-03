package com.tlongueira.questionados.services;

import java.util.List;

import com.tlongueira.questionados.dto.PreguntaDTO;
import com.tlongueira.questionados.models.Pregunta;

public interface PreguntaService {

	Pregunta crearPregunta(PreguntaDTO preguntaDTO);

	Pregunta obtenerPorId(Long id);

	List<Pregunta> obtenerTodas();

}
