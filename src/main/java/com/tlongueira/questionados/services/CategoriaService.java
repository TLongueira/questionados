package com.tlongueira.questionados.services;

import java.util.List;

import com.tlongueira.questionados.dto.CategoriaDTO;
import com.tlongueira.questionados.models.Categoria;

public interface CategoriaService {
	
	public Categoria crearCategoria(CategoriaDTO categoriaDTO);

	public Categoria obtenerPorId(Long id);

	public List<Categoria> obtenerTodas();

}
