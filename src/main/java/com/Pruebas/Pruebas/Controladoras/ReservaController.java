package com.Pruebas.Pruebas.Controladoras;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Pruebas.Pruebas.Modelo.Cliente;
import com.Pruebas.Pruebas.Modelo.Empresa;
import com.Pruebas.Pruebas.Modelo.Reservacion;
import com.Pruebas.Pruebas.Repositorios.AutorizadoRepository;
import com.Pruebas.Pruebas.Repositorios.ClienteRepository;
import com.Pruebas.Pruebas.Repositorios.EmpresaRepository;
import com.Pruebas.Pruebas.Repositorios.HistPrecioSRepository;
import com.Pruebas.Pruebas.Repositorios.ReservacionRepository;
import com.Pruebas.Pruebas.Repositorios.TipoEntradaRepository;

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
            return "registrarCliente";
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
        model.addAttribute("precioS", histPrecioSRepository.findByEntradaV(id_entrada));
        model.addAttribute("empresa", empresaRepository.findById(id_empresa));
        model.addAttribute("entrada", tipoEntradaRepository.findById(id_entrada));
        model.addAttribute("autorizacion", autorizadoRepository.findByEntradaEmpresa(id_entrada, id_empresa, ano).get());
        return "crearReserva";
    }





  
    

    
}
