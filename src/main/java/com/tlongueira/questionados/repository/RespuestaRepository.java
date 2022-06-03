package com.tlongueira.questionados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tlongueira.questionados.models.Respuesta;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long>{

}
