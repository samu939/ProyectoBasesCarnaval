package com.Pruebas.Pruebas.Controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/")
    public String inicio(){
        return "Inicio";
    }

    @GetMapping("/mantenimientoCarnaval")
    public String mantenimientoCarnaval() {
        
        return "mantenimientoCarnaval";
    }

  

}