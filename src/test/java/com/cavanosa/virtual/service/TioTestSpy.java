package com.cavanosa.virtual.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cavanosa.virtual.entity.Tio;
import com.cavanosa.virtual.repository.TioRepository;
import com.cavanosa.virtual.service.TioService;
import com.cavanosa.virtual.service.impl.TioServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.List;
import java.util.LinkedList;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TioTestSpy {
    
    @Spy
    private TioRepository tioRepository;
  
    @InjectMocks
    private TioServiceImpl tioService;

 
    @BeforeEach 
    void setUp()
    {
       
        
    }

    /* @Test
    void testSpyObtenerTios() {
        Tio tio = new Tio(2, "amiya", "amiya@gmail.com", "123456");
        Optional<Tio> optTio = Optional.of(tio);
        TioRepository tioRepository = spy(TioRepository.class);
        TioService tioService = new TioService(tioRepository);
        doReturn(optTio).when(tioRepository).findById(2);
        Optional<Tio> optTio2 = tioService.getOneById(2);
        assertTrue(optTio2.isPresent());
        Tio resultado = optTio2.get();
        assertEquals(2, resultado.getId());
        assertEquals("amiya", resultado.getNombre());
        
        verify(tioRepository).findById(anyInt());
    } */
}
