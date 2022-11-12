package com.cavanosa.virtual;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cavanosa.virtual.entity.Tio;
import com.cavanosa.virtual.repository.TioRepository;
import com.cavanosa.virtual.service.TioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.LinkedList;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TioRepoTestMockito {
    
    @Mock 
    private TioRepository tioRepository;
  
    @InjectMocks
    private TioService tioService;

 
    @BeforeEach 
    void setUp()
    {
       
        
    }
 
    @Test
    public void createTioTest()
    {
        Tio tio = new Tio("amiya", "amiya@gmail.com", "123456");
        Tio esperado = new Tio(2,"amiya", "amiya@gmail.com", "123456");
        when(tioRepository.save(tio)).thenReturn(esperado);
        Tio resultado = tioRepository.save(tio);
        assertEquals(esperado, resultado);
        verify(tioRepository).save(tio);
    }
    
    @Test
    void obtenerTioPorNombre() {
        Tio tio = new Tio(2, "amiya", "amiya@gmail.com", "123456");
        Optional<Tio> optTio = Optional.of(tio);
        when(tioRepository.findByNombre("amiya")).thenReturn(optTio);
        Optional<Tio> resultado = tioRepository.findByNombre("amiya");
        assertTrue(resultado.isPresent());
    }
    
    @Test
    void obtenerTodosLosTios(){
        List<Tio> lista = new LinkedList<Tio>();
        Tio tio1 = new Tio(1,"ejemplo13711","ejemplo13711@gmail.com","123456");
        Tio tio2 = new Tio(2,"amiya","amiya@gmail.com","123456");
        Tio tio3 = new Tio(7,"ejemplo13712","ejemplo13712@gmail.com","123456");
        lista.add(tio1);
        lista.add(tio2);
        lista.add(tio3);
        when(tioRepository.findAll()).thenReturn(lista);
        List<Tio> esperado = tioRepository.findAll();
        assertEquals(esperado, lista);
        assertEquals(esperado.size(), 3);
        verify(tioRepository).findAll();
    }
}
