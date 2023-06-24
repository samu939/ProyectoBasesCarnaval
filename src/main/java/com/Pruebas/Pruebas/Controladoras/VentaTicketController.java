package com.Pruebas.Pruebas.Controladoras;

import com.Pruebas.Pruebas.Modelo.CarnavalAnual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.Pruebas.Pruebas.Repositorios.CarnavalAnualRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Controller
public class VentaTicketController {
    @Autowired
    private CarnavalAnualRepository carnavalAnualRepository;
    @GetMapping(path = {"/SeleAnoTickect"})
    public String SeleAnoTickect(Model model) {
        List<CarnavalAnual> carnavales = carnavalAnualRepository.findAll();
        model.addAttribute("carnavales", carnavales);
        model.addAttribute("carnaval", new CarnavalAnual());
        return "SeleAnoTickect";
    }

    @PostMapping(path = {"/SeleAnoTickect"})
    public String anoSelecListEvent(CarnavalAnual carnaval){
        Optional<CarnavalAnual> carnavalElegido = carnavalAnualRepository.findById(carnaval.getAno());
        return "redirect:/EventosTicket/"+carnavalElegido.get().getAno();
    }

    @GetMapping(path = {"/EventosTicket/{ano}"})
    public String eventosList(Model model,@PathVariable("ano") LocalDate ano){

        return "EventosTicket";
    }
}
