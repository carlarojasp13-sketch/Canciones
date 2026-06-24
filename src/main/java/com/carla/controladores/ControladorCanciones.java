package com.carla.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.carla.modelos.Cancion;
import com.carla.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
    @Autowired public ServicioCanciones servicioCanciones;

    @GetMapping("/")
    public String inicio(){
        return "redirect:/canciones";
    }

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model){
        List<Cancion> canciones = servicioCanciones.obtenerTodasLasCanciones();
        model.addAttribute("canciones", canciones);
        return "canciones";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model model){
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion);
        return "detalleCancion";
    }

    @GetMapping("/canciones/formulario/agregar/{idCancion}")
        public String formularioAgregarCancion(@PathVariable long idCancion, Model model){
            Cancion cancion = new Cancion();
            model.addAttribute("cancion", cancion);
            return "agregarCancion";
        
    }

    @PostMapping("/canciones/procesa/agregar")
        public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult resultado){
            if(resultado.hasErrors()){
                return "agregarCancion";
            }
            servicioCanciones.agregarCancion(cancion);
            return "redirect:/canciones";
        }

    
}
