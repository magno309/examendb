package com.examen.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.demo.entidades.Nota;

public interface NotaRepository extends JpaRepository<Nota, Integer>{
    
}
