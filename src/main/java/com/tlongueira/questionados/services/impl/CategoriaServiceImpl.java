package com.tlongueira.questionados.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlongueira.questionados.dto.CategoriaDTO;
import com.tlongueira.questionados.models.Categoria;
import com.tlongueira.questionados.repository.CategoriaRepository;
import com.tlongueira.questionados.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepo;

	@Override
	public Categoria crearCategoria(CategoriaDTO categoriaDTO) {
		Categoria categoriaNueva= new Categoria();
		categoriaNueva.setNombre(categoriaDTO.getNombre());
		Categoria categoriaGuardada=categoriaRepo.save(categoriaNueva);
		return categoriaGuardada;
	}

	@Override
	public Categoria obtenerPorId(Long id) {
		return categoriaRepo.findById(id).get();
	}

	@Override
	public List<Categoria> obtenerTodas() {
		return categoriaRepo.findAll();
	}

}
