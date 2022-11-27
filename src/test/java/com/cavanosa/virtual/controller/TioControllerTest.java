package com.cavanosa.virtual.controller;

import com.cavanosa.virtual.entity.Tio;
import com.cavanosa.virtual.repository.TioRepository;
import com.cavanosa.virtual.service.TioService;
import com.cavanosa.virtual.service.impl.TioServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TioControllerTest.class)
class TioControllerTest {

    @Mock 
    private TioRepository tioRepository;
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TioService cuentaService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testDetalle() throws Exception {
        // Given
        Tio tio = new Tio(1,"luis", "luis@ejemplo.com", "1234567890");
        when(cuentaService.getFindById(1)).thenReturn(tio);

        // When
        mvc.perform(get("/tio/detalle/1").contentType(MediaType.APPLICATION_JSON))
        // Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("luis"))
                .andExpect(jsonPath("$.email").value("luis@ejemplo.com"));

        verify(cuentaService).getFindById(1);
    }

    @Test
    void testListar() throws Exception {
        // Given
       
        List<Tio> lista = new LinkedList<Tio>();
        Tio tio1 = new Tio(1,"luis", "luis@ejemplo.com", "1234567890");
        Tio tio2 = new Tio(2,"alberto", "alberto@ejemplo.com", "1234567890");
        Tio tio3 = new Tio(3,"elias", "elias@ejemplo.com", "1234567890");
        lista.add(tio1);
        lista.add(tio2);
        lista.add(tio3);
        when(cuentaService.findAll()).thenReturn(lista);
        // When


        mvc.perform(get("/tio/lista").contentType(MediaType.APPLICATION_JSON))
        // Then
        .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("ejemplo13711"))
                .andExpect(jsonPath("$[1].nombre").value("amiya"))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(content().json(objectMapper.writeValueAsString(lista)));

        verify(cuentaService).findAll();
    }

    @Test
    void testGuardar() throws Exception {
        // Given
        
        Tio tio = new Tio("amiya", "amiya@gmail.com", "123456");
        //when(tioRepository.save(tio)).thenReturn(esperado);
        when(cuentaService.save(tio)).then(new Answer<Tio>(){
            int secuencia = 2;
            @Override
            public Tio answer(InvocationOnMock invocation) throws Throwable{
                Tio tio = invocation.getArgument(0);
                tio.setId(secuencia++);
                return tio;
            }
        });


        // when
        mvc.perform(post("/tio/nuevo").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tio)))
        // Then
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.nombre", is("amiya")));
        verify(cuentaService).save(tio);

    }
}

