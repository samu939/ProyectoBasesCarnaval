package com.Pruebas.Pruebas.Controladoras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Pruebas.Pruebas.Modelo.Cliente;
import com.Pruebas.Pruebas.Repositorios.ClienteRepository;



@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/nuevoCliente")
    public String nuevo(Model model){
        model.addAttribute("cliente", new Cliente());
        return "registrarCliente";
    }

    @PostMapping("/nuevoCliente")
    public String crear(Cliente cliente,RedirectAttributes ra){
        clienteRepository.save(cliente);
        ra.addFlashAttribute("triunfo", "Cliente creado correctamente");
        return "redirect:/menuReservas";
    }

    

    
    
}
