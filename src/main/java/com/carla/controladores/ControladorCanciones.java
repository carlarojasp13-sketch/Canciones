package com.carla.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import com.carla.modelos.Cancion;
import com.carla.servicios.ServicioCanciones;

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
}
