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
import com.Pruebas.Pruebas.Modelo.Participante;
import com.Pruebas.Pruebas.Modelo.Presentacion;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.CalendarioPK;
import com.Pruebas.Pruebas.Repositorios.CalendarioRepostory;
import com.Pruebas.Pruebas.Repositorios.CarnavalAnualRepository;
import com.Pruebas.Pruebas.Repositorios.ParticipanteRepository;
import com.Pruebas.Pruebas.Repositorios.PresentacionRepository;

import org.springframework.ui.Model;

@Controller
public class MantenimientoResultadosCarnavalesController {
    @Autowired
    CarnavalAnualRepository carnavalAnualRepository;
    @Autowired
    PresentacionRepository  presentacionRepository;
    @Autowired
    ParticipanteRepository participanteRepository;
    @GetMapping("/resultadosCarnavales")
    public String eventos(Model model) {
        
        return "menuResultados";
    }

    @GetMapping("/elegirAnoResultadoVer")
    public String ElegirAnoEvento(Model model){
        List<CarnavalAnual> carnavales = carnavalAnualRepository.findAll();
        model.addAttribute("carnavales", carnavales);
        model.addAttribute("carnaval", new CarnavalAnual());
        
        return "elegirAnoResultado";

    }

    @PostMapping("/elegirAnoResultadoVer")
    public String AnoSeleccionadoEvento(CarnavalAnual carnaval){
        Optional<CarnavalAnual> carnavalElegido = carnavalAnualRepository.findById(carnaval.getAno());
        return "redirect:/verResultado/"+carnavalElegido.get().getAno();

    }

    @GetMapping("/verResultado/{ano}")
    public String VerResultado(Model model, @PathVariable("ano") LocalDate ano){
        Optional<CarnavalAnual> carnaval = carnavalAnualRepository.findById(ano);
        List<Presentacion> presentacionesEspecial= presentacionRepository.findAllByAno_Carnaval(ano,"especial");
        List<Presentacion> presentacionesAcceso= presentacionRepository.findAllByAno_Carnaval(ano,"acceso");
        model.addAttribute("presentacionesEspecial", presentacionesEspecial);
        model.addAttribute("presentacionesAcceso", presentacionesAcceso);
        model.addAttribute("carnaval",carnaval.get());

        
        return "verResultado";
    }
}
