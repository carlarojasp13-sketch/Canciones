package com.carla.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.carla.modelos.Artista;
import com.carla.modelos.Cancion;
import com.carla.servicios.ServicioArtistas;
import com.carla.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
    @Autowired public ServicioCanciones servicioCanciones;
    @Autowired public ServicioArtistas servicioArtistas;

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

    @GetMapping("/canciones/formulario/agregar")
        public String formularioAgregarCancion(Model model){
            Cancion cancion = new Cancion();
            model.addAttribute("cancion", cancion);
            model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "agregarCancion";
        
    }

    @PostMapping("/canciones/procesa/agregar")
        public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult resultado, @RequestParam Long idArtista, Model model){
            if(resultado.hasErrors()){
            model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
                return "agregarCancion";
            }
            Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
            cancion.setArtista(artista);
            servicioCanciones.agregarCancion(cancion);
            return "redirect:/canciones";
        }

    @GetMapping("/canciones/formulario/editar/{idCancion}")
        public String formularioEditarCancion(@PathVariable Long idCancion, Model model){
            Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
            model.addAttribute("cancion", cancion);
            model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "editarCancion";
        }

    @PostMapping("/canciones/procesa/editar/{idCancion}")
        public String procesarEditarCancion (@PathVariable Long idCancion, @Valid @ModelAttribute("cancion") Cancion cancion, BindingResult resultado, @RequestParam Long idArtista, Model model){
            if( resultado.hasErrors()){
                model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
                return "editarCancion";
            }
            Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
            cancion.setId(idCancion);
            cancion.setArtista(artista);
            servicioCanciones.actualizaCancion(cancion);
            return "redirect:/canciones";
        }
    
    @GetMapping("/canciones/eliminar/{idCancion}")
        public String eliminarCancion(@PathVariable Long idCancion){
            servicioCanciones.eliminaCancion(idCancion);
            return "redirect:/canciones";
        }
    
}
