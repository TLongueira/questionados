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

import com.tlongueira.questionados.dto.CategoriaDTO;
import com.tlongueira.questionados.models.Categoria;
import com.tlongueira.questionados.services.CategoriaService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {
	
	@Autowired
	CategoriaService categoriaService;

	@ApiOperation(value = "Crear nueva categoria", notes = "Acceder a contenido si hasRole('ADMIN').")
	@PostMapping()
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> crearCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
		Categoria nuevaCategoria=categoriaService.crearCategoria(categoriaDTO);
		
		return ResponseEntity.ok(nuevaCategoria);
	}
	
	@ApiOperation(value = "Obtener categoria por ID", notes = "Acceder a contenido si hasRole('ADMIN|USER').")
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> obtenerCategoria(@PathVariable Long id) {
		return ResponseEntity.ok(categoriaService.obtenerPorId(id));
	}
	
	@ApiOperation(value = "Obtener categorias", notes = "Acceder a contenido si hasRole('ADMIN|USER').")
	@GetMapping()
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> obtenerCategoria() {
		return ResponseEntity.ok(categoriaService.obtenerTodas());
	}
	
	

	
}
