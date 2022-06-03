package com.tlongueira.questionados.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlongueira.questionados.dto.PreguntaDTO;
import com.tlongueira.questionados.dto.RespuestaDTO;
import com.tlongueira.questionados.models.Categoria;
import com.tlongueira.questionados.models.Pregunta;
import com.tlongueira.questionados.models.Respuesta;
import com.tlongueira.questionados.repository.CategoriaRepository;
import com.tlongueira.questionados.repository.PreguntaRepository;
import com.tlongueira.questionados.repository.RespuestaRepository;
import com.tlongueira.questionados.services.PreguntaService;

@Service
public class PreguntaServiceImpl implements PreguntaService {
	@Autowired
	PreguntaRepository preguntaRepo;
	@Autowired
	CategoriaRepository categoriaRepo;
	@Autowired
	RespuestaRepository respuestaRepo;

	@Override
	public Pregunta crearPregunta(PreguntaDTO preguntaDTO) {
		Pregunta preguntaNueva=new Pregunta();
		preguntaNueva.setDescripcion(preguntaDTO.getDescripcion());
		Categoria categoria=categoriaRepo.findById(preguntaDTO.getCategoria_id()).get();;
		preguntaNueva.setCategoria(categoria);
		Pregunta preguntaGuardada=preguntaRepo.save(preguntaNueva);
		for (RespuestaDTO respuesta : preguntaDTO.getRespuestas()) {
			Respuesta respuestaNueva=new Respuesta();
			respuestaNueva.setDescripcion(respuesta.getDescripcion());
			respuestaNueva.setEsCorrecta(respuesta.getEsCorrecta());
			respuestaNueva.setPregunta(preguntaGuardada);
			respuestaRepo.save(respuestaNueva);
		}
		return preguntaGuardada;
	}

	@Override
	public Pregunta obtenerPorId(Long id) {
		return preguntaRepo.findById(id).get();
	}

	@Override
	public List<Pregunta> obtenerTodas() {
		return preguntaRepo.findAll();
	}

}
