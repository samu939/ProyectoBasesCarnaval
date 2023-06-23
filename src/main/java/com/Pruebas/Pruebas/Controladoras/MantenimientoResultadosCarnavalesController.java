package com.Pruebas.Pruebas.Controladoras;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
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
import com.Pruebas.Pruebas.Modelo.EscuelaSamba;
import com.Pruebas.Pruebas.Modelo.HistoricoGrupo;
import com.Pruebas.Pruebas.Modelo.Participante;
import com.Pruebas.Pruebas.Modelo.Presentacion;
import com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas.CalendarioPK;
import com.Pruebas.Pruebas.Repositorios.CalendarioRepostory;
import com.Pruebas.Pruebas.Repositorios.CarnavalAnualRepository;
import com.Pruebas.Pruebas.Repositorios.EscuelaSambaRepository;
import com.Pruebas.Pruebas.Repositorios.HistoricoGrupoRepository;
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
    @Autowired
    EscuelaSambaRepository escuelaSambaRepository;
    @Autowired
    HistoricoGrupoRepository historicoGrupoRepository;
    @Autowired
    CalendarioRepostory calendarioRepostory;

    @GetMapping("/resultadosCarnavales")
    public String eventos(Model model) {
        
        return "menuResultados";
    }

    @GetMapping("/elegirAnoResultadoVer")
    public String ElegirAnoResultadoVer(Model model){
        List<CarnavalAnual> carnavales = carnavalAnualRepository.findAll();
        model.addAttribute("carnavales", carnavales);
        model.addAttribute("carnaval", new CarnavalAnual());
        
        return "elegirAnoResultado";

    }

    @PostMapping("/elegirAnoResultadoVer")
    public String AnoSeleccionadoResultadoVer(CarnavalAnual carnaval){
        Optional<CarnavalAnual> carnavalElegido = carnavalAnualRepository.findById(carnaval.getAno());
        return "redirect:/verResultado/"+carnavalElegido.get().getAno();

    }

    @GetMapping("/elegirAnoResultadoCrear")
    public String ElegirAnoResultadoCrear(Model model){
        List<CarnavalAnual> carnavales = carnavalAnualRepository.findAll();
        model.addAttribute("carnavales", carnavales);
        model.addAttribute("carnaval", new CarnavalAnual());
        
        return "elegirAnoResultado";

    }

    @PostMapping("/elegirAnoResultadoCrear")
    public String AnoSeleccionadoResultadoCrear(CarnavalAnual carnaval){
        Optional<CarnavalAnual> carnavalElegido = carnavalAnualRepository.findById(carnaval.getAno());
        return "redirect:/elegirEscuelaResultadoCrear/"+carnavalElegido.get().getAno();
    }

    @GetMapping("/elegirEscuelaResultadoCrear/{ano}")
    public String ElegirEscuelaResultadoCrear(Model model,@PathVariable("ano") LocalDate ano){
        List<EscuelaSamba> escuelas = escuelaSambaRepository.findAll();
        model.addAttribute("escuelas", escuelas);
        model.addAttribute("escuela", new EscuelaSamba());
        
        return "elegirEscuelaResultado";

    }

    @PostMapping("/elegirEscuelaResultadoCrear/{ano}")
    public String EscuelaSeleccionadaResultadoCrear(EscuelaSamba escuelaSamba, @PathVariable("ano") LocalDate ano, RedirectAttributes ra){
        Optional<EscuelaSamba> escuelaElegida = escuelaSambaRepository.findById(escuelaSamba.getId());
        Optional<HistoricoGrupo> histGrupo= historicoGrupoRepository.findActiveById(escuelaSamba.getId());
        if(!histGrupo.isPresent()){
            ra.addFlashAttribute("errorHistorico", "La escuela elegida no tiene un historico de grupo activo");
            return "redirect:/resultadosCarnavales";
        }
        return "redirect:/elegirCalendarioResultadoCrear/"+ano+"/"+escuelaElegida.get().getId();
    }


    @GetMapping("/elegirCalendarioResultadoCrear/{ano}/{id}")
    public String ElegirCalendarioResultado(Model model, @PathVariable("ano") LocalDate ano, @PathVariable("id") int id){
        Optional<HistoricoGrupo> histGrupo= historicoGrupoRepository.findActiveById(id);
        List<Calendario> eventos = calendarioRepostory.findAllDesfilesByYearAndName(ano, histGrupo.get().getGrupo());
        model.addAttribute("eventos", eventos);
        model.addAttribute("evento", new Calendario());
        
        return "elegirCalendarioResultado";

    }   

    @PostMapping("/elegirCalendarioResultadoCrear/{ano}/{id}")
    public String CalendarioSeleccionadoResultado(Calendario evento,  @PathVariable("ano") LocalDate ano, @PathVariable("id") int id){
        
        return "redirect:/crearResultado/"+ano+"/"+id+"/"+evento.getId();
    }


    @GetMapping("/crearResultado/{ano}/{id}/{idCalendario}")
    public String CrearResultado(Model model, @PathVariable("ano") LocalDate ano, @PathVariable("id") int id, @PathVariable("idCalendario") int idCalendario){
        CalendarioPK calendarioPK= new CalendarioPK();
        calendarioPK.setId(idCalendario);
        Optional<CarnavalAnual> carnaval = carnavalAnualRepository.findById(ano);
        calendarioPK.setAno_carnaval(carnaval.get());
        Optional<HistoricoGrupo> histGrupo= historicoGrupoRepository.findActiveById(id);
        Optional<EscuelaSamba> escuela = escuelaSambaRepository.findById(id);
        Optional<Calendario> calendario = calendarioRepostory.findById(calendarioPK);
        model.addAttribute("calendario", calendario.get());
        model.addAttribute("escuela", escuela.get());
        
        model.addAttribute("histGrupo", histGrupo.get());
        model.addAttribute("presentacion", new Presentacion());
        
        if(histGrupo.get().getGrupo().equals("especial")){   
            int[] orden = {1,2,3,4,5,6};
            
            model.addAttribute("orden", orden);
        }else{
            int[] orden = {1,2,3,4,5,6,7,8,9,10,11,12};
            model.addAttribute("orden", orden);
        }
        
        return "crearResultado";
    }

    @PostMapping("/crearResultado/{ano}/{id}/{idCalendario}")
    public String ResultadoCreado(Presentacion presentacion, @PathVariable("ano") LocalDate ano, @PathVariable("id") int id, @PathVariable("idCalendario") int idCalendario, RedirectAttributes ra){
        CalendarioPK calendarioPK= new CalendarioPK();
        calendarioPK.setId(idCalendario);
        Optional<CarnavalAnual> carnaval = carnavalAnualRepository.findById(ano);
        calendarioPK.setAno_carnaval(carnaval.get());
        Optional<HistoricoGrupo> histGrupo= historicoGrupoRepository.findActiveById(id);
        Optional<Calendario> calendario = calendarioRepostory.findById(calendarioPK);
        presentacion.setCalendario(calendario.get());
        presentacion.setHistoricoGrupo(histGrupo.get());
        Optional<Presentacion> presentacionMA= presentacionRepository.findSameYear(presentacion.getHistoricoGrupo().getId_escuela_samba(), ano);
        if(presentacionMA.isPresent()){
            ra.addFlashAttribute("errorPresentacionMismoAno", "La escuela elegida ya tiene un resultado en el año elegido");
            return "redirect:/resultadosCarnavales";
        }
        Optional<Presentacion> presentacionMO= presentacionRepository.findSameOrder(presentacion.getCalendario().getId(), ano,presentacion.getOrden_desfile());
        if(presentacionMO.isPresent()){
            ra.addFlashAttribute("errorPresentacionMismoOrden", "Ya hay una escuela con ese orden en ese mismo evento");
            return "redirect:/crearResultado/{ano}/{id}/{idCalendario}";
        }
        if(presentacion.getHistoricoGrupo().getGrupo().equals("especial")){
            
            Optional<Presentacion> presentacionML= presentacionRepository.findSamePosEspecial(ano,presentacion.getResultado());
            if(presentacionML.isPresent()){
                ra.addFlashAttribute("errorPresentacionMismaPos", "Ya hay una escuela con esa posicion en ese mismo desfile");
                return "redirect:/crearResultado/{ano}/{id}/{idCalendario}";
            }
        }else{
            Optional<Presentacion> presentacionML= presentacionRepository.findSamePosAcceso(ano,presentacion.getResultado());
            if(presentacionML.isPresent()){
                ra.addFlashAttribute("errorPresentacionMismaPos", "Ya hay una escuela con esa posicion en ese mismo desfile");
                return "redirect:/crearResultado/{ano}/{id}/{idCalendario}";
            }
        }
        Optional<Presentacion> presentacionMH= presentacionRepository.findSameHour(presentacion.getCalendario().getId(), ano,presentacion.getHora_inicio_escuela());
        if(presentacionMH.isPresent()){
            ra.addFlashAttribute("errorPresentacionMismoOrden", "Ya hay una escuela con esa hora en ese mismo evento");
            return "redirect:/crearResultado/{ano}/{id}/{idCalendario}";
        }
        //falta crear el historico de grupo a los que decienden/ascienden
        presentacionRepository.save(presentacion);
        ra.addFlashAttribute("resultadoCreado", "Resultado creado con exito");
        return "redirect:/resultadosCarnavales";
    }
}
