package com.Pruebas.Pruebas.Controladoras;

import com.Pruebas.Pruebas.Modelo.Calendario;
import com.Pruebas.Pruebas.Modelo.CarnavalAnual;
import com.Pruebas.Pruebas.Repositorios.CalendarioRepostory;
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
    @Autowired
    CalendarioRepostory calendarioRepostory;
    @GetMapping(path = {"/SeleAnoTickect"})
    public String seleAnoTickect(Model model) {
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
        List<Calendario> eventosList = calendarioRepostory.findAllByAno_Carnaval(ano);
        model.addAttribute("eventos", eventosList);
        return "EventosTicket";
    }

    @GetMapping("SeleticketEvento/{id}/{ano}")
    public String SeleticketEvento(Model model,@PathVariable("ano") LocalDate ano,@PathVariable("id")int id){
        return "SeleticketEvento";
    }
}
