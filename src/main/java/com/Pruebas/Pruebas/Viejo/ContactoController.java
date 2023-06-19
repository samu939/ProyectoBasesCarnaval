package com.Pruebas.Pruebas.Viejo;

import java.lang.ProcessBuilder.Redirect;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

@Controller
public class ContactoController {
    
    @Autowired
    private ContactoRepository contactoRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Contacto> contactos= contactoRepository.OrderById();
        model.addAttribute("contactos", contactos);
        return "index";
    }    

    @GetMapping("/busqueda")
    public String buscar(Model model,@RequestParam(value = "query",required = false)String q){
        if (q!=""){
            List<Contacto> contactos= contactoRepository.findByNombreContaining(q);
            model.addAttribute("contactos", contactos);
            return "busqueda";
        }else{
            return "redirect:/";
        }

    }


    @GetMapping("/nuevo")
    public String nuevo(Model model){

        model.addAttribute("contacto", new Contacto());
        
        return "form";

    }
    
    @PostMapping("/nuevo")
    public String crear(Contacto contacto,RedirectAttributes ra){

        if(contactoRepository.findByNombre(contacto.getNombre())==null){
            contactoRepository.save(contacto);
            ra.addFlashAttribute("msgExitoAgregar", "El usuario ha sido creado exitosamente");
        }else
            ra.addFlashAttribute("msgFracasoAgregar", "El usuario ya existe");
        return "redirect:/";

    }

    @GetMapping("/eliminar")
    public String eliminar(Model model){

        model.addAttribute("contacto", new Contacto());

        return "delete";

    }
    
    @PostMapping("/eliminar")
    public String delete(Contacto contacto, RedirectAttributes ra){

        if(contactoRepository.findByNombre(contacto.getNombre())!=null){
            contacto=contactoRepository.findByNombre(contacto.getNombre());
            contactoRepository.deleteById(contacto.getId());
            ra.addFlashAttribute("msgExitoDelete", "Usuario borrado con exito"); 
        }
        else
            ra.addFlashAttribute("msgFracasoDelete", "El usuario a borrar no existe");    
        
        return "redirect:/";

    }


    @GetMapping("/modificar/{id}")
    public String modificar(Model model,@PathVariable("id")Integer id){

        Optional<Contacto> contMod1= contactoRepository.findById(id);
        if(contMod1.isPresent()){
            model.addAttribute("contMod", contMod1.get());
        }
        
        model.addAttribute("contacto", new Contacto());
        
        return "modificar";

    }
    
    @PostMapping("/modificar/{id}")
    public String modificado(Optional<Contacto> contMod1,Contacto contacto,RedirectAttributes ra){
        Optional<Contacto> contMod= contactoRepository.findById(contMod1.get().getId());
        if(contacto.getFechaNacimiento()==null)
            contacto.setFechaNacimiento(contMod.get().getFechaNacimiento());
        if(contacto.getNombre()=="")
            contacto.setNombre(contMod.get().getNombre());
            
        contacto.setId(contMod.get().getId());    
        contacto.setFechaRegistro(contMod.get().getFechaRegistro());
        contactoRepository.save(contacto);
        ra.addFlashAttribute("msgExitoModificar", "El usuario ha sido modificado exitosamente");
        
        return "redirect:/";

    }
}
