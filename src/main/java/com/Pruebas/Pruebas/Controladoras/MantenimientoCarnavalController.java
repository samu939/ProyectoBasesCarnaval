package com.Pruebas.Pruebas.Controladoras;

import java.lang.ProcessBuilder.Redirect;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Pruebas.Pruebas.Modelo.Calendario;
import com.Pruebas.Pruebas.Repositorios.CalendarioRepostory;

import org.springframework.ui.Model;

@Controller
public class MantenimientoCarnavalController {
    
    @Autowired
    private CalendarioRepostory calendarioRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Calendario> Eventos=  calendarioRepository.findAll();
        model.addAttribute("eventos", Eventos);
        return "index";
    }
}    