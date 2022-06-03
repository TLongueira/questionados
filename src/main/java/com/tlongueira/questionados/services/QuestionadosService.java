package com.tlongueira.questionados.services;

import com.tlongueira.questionados.dto.PreguntaUsuarioDTO;
import com.tlongueira.questionados.dto.RespuestaUsuarioDTO;

public interface QuestionadosService {
PreguntaUsuarioDTO obtenerPreguntaRandomByCategoriaId(Long id);

Boolean validarRespuesta(RespuestaUsuarioDTO respuestaUsuarioDTO);
}
