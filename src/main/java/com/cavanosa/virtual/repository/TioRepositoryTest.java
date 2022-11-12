package com.cavanosa.virtual.repository;

import java.util.Optional;

import com.cavanosa.virtual.entity.Tio;
import java.util.List;


public interface TioRepositoryTest {
    Optional<Tio> findByNombre(String nombre);
    Optional<Tio> findByEmail(String email);
    boolean existsByNombre(String nombre);
    boolean existsByEmail(String email);
    List<Tio> findAll();
    Tio save(Tio tio);
}
