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
public class AnoCarnavalController {
    @Autowired
    private CarnavalAnualRepository carnavalAnualRepository;
    @Autowired
    private ParticipanteRepository participanteRepository;
    @GetMapping("/crearAnoCarnaval")
    public String crearAnoCarnaval(Model model, RedirectAttributes ra) {
        List<Participante> participantesH=participanteRepository.findAllByGenero('M');
        List<Participante> participantesF=participanteRepository.findAllByGenero('F');
        if(participantesF.size()==0 || participantesH.size()==0){
            ra.addFlashAttribute("errorCrearAno", "Tiene que haber al menos 1 participante hombre y 1 mujer guardados para crear un nuevo año");
                return "redirect:/mantenimientoCarnaval";
        }
        model.addAttribute("carnaval", new CarnavalAnual());
        model.addAttribute("participantesH", participantesH);
        model.addAttribute("participantesF", participantesF);
        return "crearAnoCarnaval";
    }

    @PostMapping("/crearAnoCarnaval")
    public String crearAnoCarnaval(CarnavalAnual carnaval, Model model, RedirectAttributes redirectAttributes) {
        Optional<CarnavalAnual> carnavalAnual = carnavalAnualRepository.findById(carnaval.getAno());
        List<CarnavalAnual> carnavalesAnuales= carnavalAnualRepository.findAll();
        if(carnavalesAnuales.size()!=0){
            Optional<CarnavalAnual> carnavalAnoAnterior = carnavalAnualRepository.findById(carnaval.getAno().minusYears(1));
            if(!carnavalAnoAnterior.isPresent()){
                redirectAttributes.addFlashAttribute("errorCrearAno", "Los años de carnavales no pueden ser menores al primero creado y tienen que ser consecutivos, no existe carnaval del año anterior");
                return "redirect:/mantenimientoCarnaval";
            }
            
            if (carnavalAnual.isPresent()) {
                redirectAttributes.addFlashAttribute("errorCrearAno", "El año de carnaval ya existe");
                return "redirect:/mantenimientoCarnaval";
            }
        }
        carnavalAnualRepository.save(carnaval);
        redirectAttributes.addFlashAttribute("successCrearAno", "El año de carnaval se ha creado correctamente");
        return "redirect:/mantenimientoCarnaval";
    }

}
