package com.examen.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.demo.entidades.Respuesta;

public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {
    
}
