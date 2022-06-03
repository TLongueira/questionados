package com.tlongueira.questionados.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tlongueira.questionados.dto.RespuestaUsuarioDTO;
import com.tlongueira.questionados.services.QuestionadosService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/questionados")
public class QuestionadosController {

	@Autowired
	QuestionadosService questionadosService;

	//obtener pregunta random segun categoria
	@ApiOperation(value = "Obtener pregunta random segun id Categoria", notes = "Acceder a contenido si hasRole('USER').")
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> obtenerPreguntaSegundCategoria(@PathVariable Long id) {
		return ResponseEntity.ok(questionadosService.obtenerPreguntaRandomByCategoriaId(id));
	}

	// responder pregunta random
	@ApiOperation(value = "Responder pregunta random con id pregunta e id respuesta", notes = "Acceder a contenido si hasRole('USER').")
	@PostMapping()
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> responderPregunta(@Valid @RequestBody RespuestaUsuarioDTO respuestaUsuarioDTO) {
		return ResponseEntity.ok(questionadosService.validarRespuesta(respuestaUsuarioDTO));
	}

}
