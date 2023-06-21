package com.Pruebas.Pruebas.Controladoras;

import java.lang.ProcessBuilder.Redirect;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Pruebas.Pruebas.Modelo.Calendario;
import com.Pruebas.Pruebas.Modelo.CarnavalAnual;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.CalendarioPK;
import com.Pruebas.Pruebas.Repositorios.CalendarioRepostory;
import com.Pruebas.Pruebas.Repositorios.CarnavalAnualRepository;
import com.Pruebas.Pruebas.Viejo.Contacto;

import org.springframework.ui.Model;

@Controller
public class MantenimientoCarnavalController {
    
    @Autowired
    private CalendarioRepostory calendarioRepository;
    @Autowired
    private CarnavalAnualRepository carnavalAnualRepository;

    @GetMapping("/mantenimientoCarnaval")
    public String inicio() {
        
        return "mantenimientoCarnaval";
    }

    @GetMapping("/eventos")
    public String eventos(Model model) {
        List<Calendario> eventos=  calendarioRepository.OrderByFecha();
        model.addAttribute("eventos", eventos);
        return "Eventos";
    }

    @GetMapping("/buscarEventos")
    public String buscarEventos(Model model,@RequestParam(value = "query",required = false)String q){
        if (q!=""){
            List<Calendario> eventos= calendarioRepository.findByNombreContainingIgnoreCase(q);
            model.addAttribute("eventos", eventos);
            return "busquedaEventos";
        }else{
            return "redirect:/eventos";
        }

    }
    
    @GetMapping("/verEvento/{id}")
    public String verEvento(Model model,@RequestParam("ano") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate ano,@PathVariable("id")int id){
        CalendarioPK eventoPK= new CalendarioPK();
        Optional<CarnavalAnual> carnaval = carnavalAnualRepository.findById(ano);
        eventoPK.setAno_carnaval(carnaval.get());
        eventoPK.setId(id);
        Optional<Calendario> evento= calendarioRepository.findById(eventoPK);
        model.addAttribute("evento", evento.get());
        
        return "verEvento";

    }

    @GetMapping("/elegirAnoEvento")
    public String ElegirAnoEvento(Model model){
        List<CarnavalAnual> carnavales = carnavalAnualRepository.findAll();
        model.addAttribute("carnavales", carnavales);
        model.addAttribute("carnaval", new CarnavalAnual());
        
        return "elegirAnoEvento";

    }

    @PostMapping("/elegirAnoEvento")
    public String AnoSeleccionadoEvento(CarnavalAnual carnaval){
        Optional<CarnavalAnual> carnavalElegido = carnavalAnualRepository.findById(carnaval.getAno());
        return "redirect:/CrearEvento/"+carnavalElegido.get().getAno();

    }

    @GetMapping("/CrearEvento/{ano}")
    public String CrearEvento(Model model,@PathVariable("ano")LocalDate ano){

        model.addAttribute("calendario", new Calendario());
        
        model.addAttribute("ano", ano);
        
        return "crearEvento";

    }
    
    @PostMapping("/CrearEvento/{ano}")
    public String EventoCreado(Calendario calendario,RedirectAttributes ra, @PathVariable("ano")LocalDate ano){
        
        Optional <CarnavalAnual> anoCarnaval= carnavalAnualRepository.findById(ano);
        calendario.setAno_carnaval(anoCarnaval.get());
        try{
            calendarioRepository.save(calendario);
        }catch(Exception e){
            ra.addFlashAttribute("msgFracasoAgregar", "Error al crear el Evento: "+e);
            return "redirect:/eventos";
        }
        ra.addFlashAttribute("msgExitoAgregar", "El evento ha sido creado exitosamente");
        
        return "redirect:/eventos";

    }
}    