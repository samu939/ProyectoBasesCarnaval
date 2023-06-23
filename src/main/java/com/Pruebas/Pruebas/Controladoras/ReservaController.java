package com.Pruebas.Pruebas.Controladoras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Pruebas.Pruebas.Modelo.Reservacion;
import com.Pruebas.Pruebas.Repositorios.ReservacionRepository;

import org.springframework.ui.Model;

@Controller
public class ReservaController {

    @Autowired
    private ReservacionRepository reservacionRepository;

    @GetMapping("/menuReservas")
    public String reserva(Model model){
        return "menuReservas";
    }

    @GetMapping("/crearReserva")
    public String nuevaReserva(Model model){
        model.addAttribute("reservas", new Reservacion());
        return "crearReserva";
    }

    @PostMapping
    public String crearReserva(Reservacion reserva, RedirectAttributes ra){
        reservacionRepository.save(reserva);
        ra.addFlashAttribute("msgExitoAgregar", "Se ha generado la reserva de forma exitosa");
        return "redirect:/menuReservas";
    }
    

    
}
