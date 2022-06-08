package com.examen.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.examen.demo.entidades.Personal;
import com.examen.demo.repositorios.PersonalRepository;

@Controller
public class PersonalController {

    @Autowired
    PersonalRepository personalRepository;

    @GetMapping("/personal/agregar")
    public String frmAgregarNota(Model modelo){
        modelo.addAttribute("personal", new Personal());
        return "frmPersonal";
    }

    @PostMapping("/personal/guardar")
    public String guardarNota(Personal personal){
        personalRepository.save(personal);
        return "redirect:/";
    }
    
}
