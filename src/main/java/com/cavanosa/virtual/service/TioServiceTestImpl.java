package com.cavanosa.virtual.service;

import com.cavanosa.virtual.entity.Tio;
import com.cavanosa.virtual.repository.TioRepositoryTest;
import java.util.List;
import java.util.Optional;


public class TioServiceTestImpl {
    private TioRepositoryTest tioRepository;
 
    public TioServiceTestImpl(TioRepositoryTest tioRepository) {
        this.tioRepository = tioRepository;
    }

    
    public Optional<Tio> findTioPorNombre(String nombre) {
        return tioRepository.findAll()
                .stream()
                .filter(e -> e.getNombre().contains(nombre))
                .findFirst();
    }

    public Optional<Tio> getOneByNombre(String nombre) {
        return tioRepository.findByNombre(nombre);
    }
    
    public Tio save(Tio tio) {
        Tio eje = new Tio();
        if(tioRepository.existsByNombre(tio.getNombre()) || tioRepository.existsByEmail(tio.getEmail())) {
            return eje;
        }
        return tioRepository.save(tio);
    }
}
