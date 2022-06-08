package com.examen.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.examen.demo.entidades.Nota;
import com.examen.demo.repositorios.NotaRepository;

@Controller
public class AppController {

    @Autowired
    NotaRepository notaRepository;

    @GetMapping("/")
    public String goToIndex(Model modelo) {
        List<Nota> listaNotas = notaRepository.findAll();
        modelo.addAttribute("listaNotas", listaNotas);
        return "index";
    }

}
