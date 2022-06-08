package com.examen.demo.controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.examen.demo.entidades.Nota;
import com.examen.demo.repositorios.NotaRepository;

@Controller
public class NotaController {
    
    @Autowired
    NotaRepository notaRepository;

    @GetMapping("/notas/agregar")
    public String frmAgregarNota(Model modelo){
        modelo.addAttribute("nota", new Nota());
        return "frmNota";
    }

    @PostMapping("/notas/guardar")
    public String guardarNota(Nota nota){
        nota.setFecha(new Date());
        notaRepository.save(nota);
        return "redirect:/";
    }
}
