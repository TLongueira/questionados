package com.tlongueira.questionados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tlongueira.questionados.models.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long>{

}
