package com.tlongueira.questionados.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlongueira.questionados.dto.PreguntaUsuarioDTO;
import com.tlongueira.questionados.dto.RespuestaDTO;
import com.tlongueira.questionados.dto.RespuestaUsuarioDTO;
import com.tlongueira.questionados.models.Pregunta;
import com.tlongueira.questionados.models.Respuesta;
import com.tlongueira.questionados.repository.PreguntaRepository;
import com.tlongueira.questionados.repository.RespuestaRepository;
import com.tlongueira.questionados.services.QuestionadosService;

@Service
public class QuestionadosServiceImpl implements QuestionadosService {
	@Autowired
	PreguntaRepository preguntaRepo;
	@Autowired
	RespuestaRepository respuestaRepo;

	@Override
	public PreguntaUsuarioDTO obtenerPreguntaRandomByCategoriaId(Long id) {
//		List<Pregunta> listaPreguntas = preguntaRepo.buscarPorCategoriaId(id);
//		int cantidadPreguntas = listaPreguntas.size();
//		Random rand = new Random();
//		Pregunta preguntaRandom = listaPreguntas.get(rand.nextInt(0, cantidadPreguntas));
		Pregunta preguntaRandom = preguntaRepo.getPreguntaRandom();
		PreguntaUsuarioDTO preguntaObtenida = new PreguntaUsuarioDTO();
		preguntaObtenida.setDescripcion(preguntaRandom.getDescripcion());
		preguntaObtenida.setId(preguntaRandom.getId());
		Set<RespuestaDTO> respuestas = new HashSet<>();
		for (Respuesta respuesta : preguntaRandom.getRespuestas()) {
			RespuestaDTO respuestaFE = new RespuestaDTO();
			respuestaFE.setRespuestaId(respuesta.getId());
			respuestaFE.setDescripcion(respuesta.getDescripcion());
			respuestas.add(respuestaFE);
		}
		preguntaObtenida.setRespuestas(respuestas);
		return preguntaObtenida;
	}

	@Override
	public Boolean validarRespuesta(RespuestaUsuarioDTO respuestaUsuarioDTO) {
		Respuesta respuestaUsuario = respuestaRepo.findById(respuestaUsuarioDTO.getIdRespuesta()).get();
		if (respuestaUsuario.getEsCorrecta()) {
			return true;
		} else {
			return false;
		}
	}

}
