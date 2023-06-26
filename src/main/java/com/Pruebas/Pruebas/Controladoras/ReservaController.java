package com.Pruebas.Pruebas.Controladoras;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.Pruebas.Pruebas.Modelo.*;
import com.Pruebas.Pruebas.Repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.ui.Model;

@Controller
public class ReservaController {

    @Autowired
    private ReservacionRepository reservacionRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private AutorizadoRepository autorizadoRepository;
    @Autowired
    private TipoEntradaRepository tipoEntradaRepository;
    @Autowired
    private HistPrecioSRepository histPrecioSRepository;

    @Autowired
    private HistPrecioSInsertRepository histPrecioSInsertRepository;
    @Autowired
    private detalleReservacionInsertRepository detalleReservacionRepositry;

    @GetMapping("/menuReservas")
    public String reserva(Model model){
        model.addAttribute("cliente", new Cliente());
        return "menuReservas";
    }

    @PostMapping("/menuReservas")
    public String buscar(Cliente cliente){
        if(clienteRepository.findByDocidentidad(cliente.getDocidentidad()).isPresent()){
            return "redirect:/busquedaEmpresas/"+cliente.getDocidentidad();
        }else{
            return "redirect:/nuevoCliente";
        }
    }

    @GetMapping("/busquedaEmpresas/{docide}")
    public String buscarEmpresas(Model model,@PathVariable("docide") Long docidentidad){
        //docide=docidentidad cliente
        List<Empresa> empresasRegistradas=empresaRepository.findAll();
        model.addAttribute("clienteBuscado",clienteRepository.findByDocidentidad(docidentidad).get());
        model.addAttribute("empresasRegistradas", empresasRegistradas);
        return "verEmpresas";
    }

    @GetMapping("/cantidadEmpresa/{dociden}/{id}")
    public String mostrarTicketsCantidad(Model model,@PathVariable("dociden") Long docidentidad, @PathVariable("id") int id){
        model.addAttribute("entradasEmpresa", tipoEntradaRepository.findAllEntradasDispo(id));
        model.addAttribute("entradasExistencia", autorizadoRepository.findAllEntradasDispoA(id));
        model.addAttribute("clienteBuscado", clienteRepository.findByDocidentidad(docidentidad).get());
        return "cantidadxEmpresa";
    }


    @GetMapping("/crearReserva/{dociden}/{id_empresa}/{id_entrada}/{ano}")
    public String crearReserva(Model model,@PathVariable("dociden") Long dociden,@PathVariable("id_empresa") int id_empresa, @PathVariable("id_entrada") int id_entrada,@PathVariable("ano") LocalDate ano){
        model.addAttribute("reserva", new Reservacion());
        model.addAttribute("historico", histPrecioSRepository.findByEntradaV(id_entrada).get());
        model.addAttribute("empresa", empresaRepository.findById(id_empresa).get());
        model.addAttribute("entrada", tipoEntradaRepository.findById(id_entrada).get());
        model.addAttribute("cliente", clienteRepository.findByDocidentidad(dociden).get());
        model.addAttribute("autorizacion", autorizadoRepository.findByEntradaEmpresa(id_entrada, id_empresa, ano).get());
        return "crearReserva";
    }

    @PostMapping("/crearReserva/{dociden}/{id_empresa}/{id_entrada}/{ano}")
    public String ReservaCreada(Reservacion reserva,@PathVariable("dociden") Long dociden,@PathVariable("id_empresa") int id_empresa, @PathVariable("id_entrada") int id_entrada,@PathVariable("ano") LocalDate ano){
        Optional<Cliente>cliente=clienteRepository.findByDocidentidad(dociden);
        Optional<Empresa>empresa=empresaRepository.findById(id_empresa);
        Optional<Autorizado>autorizacion=autorizadoRepository.findByEntradaEmpresa(id_entrada, id_empresa, ano);
        Optional<HistoricoPrecioS>historico=histPrecioSRepository.findByEntradaV(id_entrada);
        reserva.setId_cliente(cliente.get());
        reserva.setId_empresa(empresa.get());
        DetalleReservacion detalleReservacion = new DetalleReservacion();
        detalleReservacion.setAutorizado(autorizacion.get());
        reserva.setNumero(reservacionRepository.findLastByNumber().get().getNumero());
        detalleReservacion.setReservacion(reserva);
        double division = reserva.getTotal()/historico.get().getPrecio();
        double parteDecimal = division%1;
        double parteEntera = division-parteDecimal;
        detalleReservacion.setCantidad((int)parteEntera);
        detalleReservacionRepositry.inserDetalleNuevo(detalleReservacion);
        reservacionRepository.save(reserva);
        
        
        
        
        return "redirect:/menuReservas";
    }



    /*---------------------Arturo Parte------------------------*/

    @GetMapping(path = {"/MenuOpciones"})
    public String MenuOpciones(){
        return "MenuOpciones";
    }

    @GetMapping(path = {"/HistoricoPrecioS"})
    public String HistoricoPrecioS(Model model){
        List<TipoEntrada> entradaSambodromo = tipoEntradaRepository.OrderById();
        model.addAttribute("entradaSambodromo", entradaSambodromo);
        return "HistoricoPrecioS";
    }

    @GetMapping(path = {"/ModificarHistorico/{id}"})
    public String ModificarHistorico(Model model,@PathVariable("id")int id){
        model.addAttribute("historicoPrecioS", new HistoricoPrecioS());
        model.addAttribute("idEntrada", id);
        return "ModificarHistorico";
    }

    @PostMapping("/ModificarHistorico/{id}")
    public String HistoricoPrecioCreado(HistoricoPrecioS historicoPrecioS, RedirectAttributes ra, @PathVariable("id")int id){
        TipoEntrada entradaObject = new TipoEntrada();
        entradaObject.setId(id);
        Optional<HistoricoPrecioS> historicoPrecioSList = histPrecioSRepository.findAllByIdFechaActivo(id);
        if(historicoPrecioS.getFechai().isBefore(historicoPrecioSList.get().getFechai()) ){
            ra.addFlashAttribute("error", "La fecha de inicio del nuevo registro tiene que ser mayor al del anterior: "+historicoPrecioSList.get().getFechai());
            return "redirect:/HistoricoPrecioS";
        }
        if(historicoPrecioSList.isEmpty()){
            historicoPrecioS.setFechaf(null);
            historicoPrecioS.setId_tipo_entrada(entradaObject);
        }else{
            historicoPrecioSList.get().setFechaf(historicoPrecioS.getFechai());
            historicoPrecioS.setFechaf(null);
            historicoPrecioS.setId_tipo_entrada(entradaObject);
        }

        try{
            histPrecioSInsertRepository.insertHistoricoNuevo(historicoPrecioS);
        }catch(Exception e){
            return "redirect:/HistoricoPrecioS";
        }


        ra.addFlashAttribute("triunfo", "Nuevo historico de precio creado con éxito");
        return "redirect:/HistoricoPrecioS";
    }

  
    

    
}
