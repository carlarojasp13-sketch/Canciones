package com.carla.repositorios;

import org.springframework.stereotype.Repository;

import com.carla.modelos.Artista;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long>{
    List<Artista> findAll();
}
