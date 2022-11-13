package com.cavanosa.virtual;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cavanosa.virtual.entity.Tio;
import com.cavanosa.virtual.repository.TioRepository;
import com.cavanosa.virtual.service.TioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

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
        //when(tioRepository.save(tio)).thenReturn(esperado);
        when(tioRepository.save(any(Tio.class))).then(new Answer<Tio>(){
            int secuencia = 2;
            @Override
            public Tio answer(InvocationOnMock invocation) throws Throwable{
                Tio tio = invocation.getArgument(0);
                tio.setId(secuencia++);
                return tio;
            }
        });
        Tio resultado = tioRepository.save(tio);
        assertEquals(esperado, resultado);
        verify(tioRepository).save(tio);
        verify(tioRepository).save(any(Tio.class));
    }

    @Test
    void testCrearNombreNullException() {
        
        when(tioRepository.findByNombre(isNull())).thenThrow(new IllegalArgumentException());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tioRepository.findByNombre(null);
        });
        assertEquals(IllegalArgumentException.class, exception.getClass());
        verify(tioRepository).findByNombre(isNull());

    }

    @Test
    void obtenerUnTioPorId(){
        Tio tio = new Tio(2, "amiya", "amiya@gmail.com", "123456");
        Optional<Tio> optTio = Optional.of(tio);
        when(tioRepository.findById(2)).thenReturn(optTio);
        Optional<Tio> resultado = tioRepository.findById(2);
        assertTrue(resultado.isPresent());
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
    void obtenerLosTiosPorId(){
        Tio tio = new Tio(2, "amiya", "amiya@gmail.com", "123456");
        Optional<Tio> optTio = Optional.of(tio);
        when(tioRepository.findById(2)).thenReturn(optTio);
        Optional<Tio> resultado = tioRepository.findById(2);
        assertTrue(resultado.isPresent());
        verify(tioRepository).findById(argThat(arg -> arg != null && arg > 0 && arg < 8));
    }

    @Test
    void testArgumentMatchers2() {
        Tio tio = new Tio(2, "amiya", "amiya@gmail.com", "123456");
        Optional<Tio> optTio = Optional.of(tio);
        when(tioRepository.findById(anyInt())).thenReturn(optTio);
        Optional<Tio> resultado = tioRepository.findById(2);
        assertTrue(resultado.isPresent());
        //no da error por que el valor buscado cumple con la norma
        verify(tioRepository).findById(argThat(new MiArgsMatchers()));

    }

    public static class MiArgsMatchers implements ArgumentMatcher<Integer>{

        private Integer argument;

        @Override
        public boolean matches(Integer argument) {
            this.argument = argument;
            return argument != null && argument > 0;
        }

        @Override
        public String toString() {
            return argument + " debe ser un entero positivo";
        }
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
