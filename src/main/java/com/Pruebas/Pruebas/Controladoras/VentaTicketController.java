package com.Pruebas.Pruebas.Controladoras;

import com.Pruebas.Pruebas.Modelo.Calendario;
import com.Pruebas.Pruebas.Modelo.CarnavalAnual;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.CalendarioPK;
import com.Pruebas.Pruebas.Modelo.TicketEvento;
import com.Pruebas.Pruebas.Repositorios.CalendarioRepostory;
import com.Pruebas.Pruebas.Repositorios.TicketEventoRepositoy;
import com.Pruebas.Pruebas.Repositorios.ticketEventoInsertRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.Pruebas.Pruebas.Repositorios.CarnavalAnualRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Controller
public class VentaTicketController {
    @Autowired
    private CarnavalAnualRepository carnavalAnualRepository;
    @Autowired
    CalendarioRepostory calendarioRepostory;
    @Autowired
    TicketEventoRepositoy ticketEventoRepositoy;
    @Autowired
    ticketEventoInsertRepository ticketEventoInsertRepository;
    @GetMapping(path = {"/SeleAnoTicket"})
    public String seleAnoTickect(Model model,RedirectAttributes ra) {
        List<CarnavalAnual> carnavales = carnavalAnualRepository.findAll();
        if(carnavales.size()==0){
            ra.addFlashAttribute("error", "No hay años registrados en el sistema");
            return "redirect:/";
        }
        model.addAttribute("carnavales", carnavales);
        model.addAttribute("carnaval", new CarnavalAnual());
        return "SeleAnoTicket";
    }

    @PostMapping(path = {"/SeleAnoTicket"})
    public String anoSelecListEvent(CarnavalAnual carnaval){
        Optional<CarnavalAnual> carnavalElegido = carnavalAnualRepository.findById(carnaval.getAno());
        return "redirect:/EventosTicket/"+carnavalElegido.get().getAno();
    }

    @GetMapping(path = {"/EventosTicket/{ano}"})
    public String eventosList(Model model,@PathVariable("ano") LocalDate ano,RedirectAttributes ra){
        List<Calendario> eventosList = calendarioRepostory.findAllByAno_Carnaval(ano);
        if(eventosList.size()==0){
            ra.addFlashAttribute("error", "No hay eventos registrados en ese año");
            return "redirect:/SeleAnoTicket";
        }
        model.addAttribute("eventos", eventosList);
        return "EventosTicket";
    }

    @GetMapping("/SeleTicketEvento/{id}/{ano}")
    public String SeleTicketEvento(Model model,@PathVariable("ano") LocalDate ano,@PathVariable("id")int id){
        List<Calendario> eventoEspecifico = calendarioRepostory.findAllByAno_Carnaval_Id(ano,id);
        model.addAttribute("eventoEspecifico", eventoEspecifico);
        model.addAttribute("ticketEvento", new TicketEvento());
        model.addAttribute("ano", ano);
        model.addAttribute("id", id);
        return "SeleTicketEvento";
    }

    @PostMapping("/SeleTicketEvento/{id}/{ano}")
    public String ticketGuardado(TicketEvento ticketEvento, RedirectAttributes ra, @PathVariable("ano") LocalDate ano, @PathVariable("id")int id){
        CalendarioPK calendarioPK = new CalendarioPK();
        calendarioPK.setId(id);
        Optional<CarnavalAnual> carnaval = carnavalAnualRepository.findById(ano);
        calendarioPK.setAno_carnaval(carnaval.get());
        Optional<Calendario> eventoEspecifico = calendarioRepostory.findById(calendarioPK);
        ticketEvento.setCalendario(eventoEspecifico.get());
        ticketEvento.setDescripcion(eventoEspecifico.get().getDescripcion());
        ticketEvento.setCosto(eventoEspecifico.get().getCosto());

        try{
            ticketEventoInsertRepository.inserTicketEventoNuevoNuevo(ticketEvento);
            ra.addFlashAttribute("triunfo","Se ha guardado el ticket");
            
        }catch(Exception e){
            ra.addFlashAttribute("error","No se pudo guardar el ticket");
            return "redirect:/EventosTicket/" + ano;
        }
        return  "redirect:/EventosTicket/" + ano;
    }

    @GetMapping(path = {"/TicketsVendidos"})
    public String Tickets(Model model){
        List<TicketEvento> ticketEventos = ticketEventoRepositoy.OrderByAno_carnaval();
        model.addAttribute("ticketEventoList", ticketEventos);
        return "TicketsVendidos";
    }
}
