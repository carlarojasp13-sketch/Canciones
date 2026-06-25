package com.carla.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carla.modelos.Artista;
import com.carla.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {
    @Autowired private RepositorioArtistas repositorioArtistas;

    public List<Artista> obtenerTodosLosArtistas(){
        return repositorioArtistas.findAll();
    }

    public Artista obtenerArtistaPorId(Long id){
        Optional<Artista> artista = repositorioArtistas.findById(id);
        if(artista.isPresent()){
            return artista.get();
        } else {
            return null;
        }
    }

    public Artista agregarArtista(Artista artista){
        return repositorioArtistas.save(artista);
    }
}
