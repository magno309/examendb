package com.examen.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.demo.entidades.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Integer>{
    
}
