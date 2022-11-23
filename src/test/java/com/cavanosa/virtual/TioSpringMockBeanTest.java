package com.cavanosa.virtual;


import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.cavanosa.virtual.entity.Tio;
import com.cavanosa.virtual.repository.TioRepository;
import com.cavanosa.virtual.service.TioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Order;

public class TioSpringMockBeanTest {
    @MockBean 
    private TioRepository tioRepository;
  
    @Autowired
    private TioService tioService;

 
    @BeforeEach 
    void setUp()
    {
       
        
    }


    /* @Test
    @Order(4)
    public void createTioTestSame()
    {
        Tio tio = new Tio(2,"amiya", "amiya@gmail.com", "123456");
        Tio esperado = new Tio(2,"amiya", "amiya@gmail.com", "123456");
        when(tioRepository.save(tio)).thenReturn(esperado);
        when(tioService.save(tio)).thenReturn(true);
        Tio resultado = tioRepository.save(tio);
        boolean resultado2 = tioService.save(tio);
        //comparando objetos
        assertSame(esperado, resultado);
        assertTrue(resultado2);
    } */
}
