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

import com.tlongueira.questionados.dto.PreguntaDTO;
import com.tlongueira.questionados.models.Pregunta;
import com.tlongueira.questionados.services.PreguntaService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/preguntas")
public class PreguntasController {
	
	@Autowired
	PreguntaService preguntaService;
	
	@ApiOperation(value = "Crear nueva pregunta", notes = "Acceder a contenido si hasRole('ADMIN').")
	@PostMapping()
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> crearPregunta(@Valid @RequestBody PreguntaDTO preguntaDTO) {
		//Categoria nuevaCategoria=categoriaService.crearCategoria(categoriaDTO);
		Pregunta nuevaPregunta=preguntaService.crearPregunta(preguntaDTO);
		
		return ResponseEntity.ok(nuevaPregunta);
	}
	
	@ApiOperation(value = "Obtener pregunta por ID", notes = "Acceder a contenido si hasRole('ADMIN|USER').")
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> obtenerPregunta(@PathVariable Long id) {
		return ResponseEntity.ok(preguntaService.obtenerPorId(id));
	}
	@ApiOperation(value = "Obtener preguntas", notes = "Acceder a contenido si hasRole('ADMIN|USER').")
	@GetMapping()
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> obtenerPregunta() {
		return ResponseEntity.ok(preguntaService.obtenerTodas());
	}

	
}
