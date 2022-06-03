package com.tlongueira.questionados.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlongueira.questionados.dto.RespuestaDTO;
import com.tlongueira.questionados.models.Pregunta;
import com.tlongueira.questionados.models.Respuesta;
import com.tlongueira.questionados.repository.PreguntaRepository;
import com.tlongueira.questionados.repository.RespuestaRepository;
import com.tlongueira.questionados.services.RespuestaService;

@Service
public class RespuestaServiceImpl implements RespuestaService {
	@Autowired
	RespuestaRepository respuestaRepo;

	@Autowired
	PreguntaRepository preguntaRepo;

	@Override
	public Respuesta obtenerPorId(Long id) {
		return respuestaRepo.findById(id).get();
	}

	@Override
	public List<Respuesta> obtenerTodas() {
		return respuestaRepo.findAll();
	}

	@Override
	public Respuesta crearRespuesta(RespuestaDTO respuestaDTO) {
		Respuesta respuestaNueva = new Respuesta();
		respuestaNueva.setDescripcion(respuestaDTO.getDescripcion());
		respuestaNueva.setEsCorrecta(respuestaDTO.getEsCorrecta());
		Pregunta pregunta = preguntaRepo.findById(respuestaDTO.getPregunta_id()).get();
		respuestaNueva.setPregunta(pregunta);
		Respuesta respuestaGuardada = respuestaRepo.save(respuestaNueva);
		return respuestaGuardada;
	}

}
