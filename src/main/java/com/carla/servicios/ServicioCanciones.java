package com.carla.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carla.modelos.Cancion;
import com.carla.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
    @Autowired private RepositorioCanciones repositorioCanciones;

    public List<Cancion> obtenerTodasLasCanciones(){
        return repositorioCanciones.findAll();
    }

    public Cancion obtenerCancionPorId(Long id){
        Optional<Cancion> cancion = repositorioCanciones.findById(id);

        if(cancion.isPresent()){
            return cancion.get();
        } else {
            return null;
    }
}
}
