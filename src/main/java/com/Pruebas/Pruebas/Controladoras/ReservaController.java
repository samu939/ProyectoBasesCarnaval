package com.Pruebas.Pruebas.Controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ReservaController {

    @GetMapping("/menuReservas")
    public String reserva(Model model){
        return "menuReservas";
    }

    

    

    
}
