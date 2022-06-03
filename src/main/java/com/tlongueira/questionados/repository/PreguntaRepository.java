package com.tlongueira.questionados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tlongueira.questionados.models.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long>{
	@Query("SELECT p FROM Pregunta p WHERE p.categoria.id = :categoriaId")
	List<Pregunta> buscarPorCategoriaId(
			 @Param("categoriaId") Long categoriaId
			);
	
	@Query(nativeQuery = true,value="SELECT p FROM Pregunta p WHERE p.categoria.id = :categoriaId ORDER BY RANDOM() LIMIT 1")
	Pregunta getPreguntaRandom(
			 @Param("categoriaId") Long categoriaId
			);
}
