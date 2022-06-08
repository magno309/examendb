package com.examen.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.demo.entidades.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer>{
    
}
