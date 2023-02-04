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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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

/*     @Test
    void testDetalle() throws Exception {
        // Given
        Tio tio1 = new Tio(1,"ejemplo13711","ejemplo13711@gmail.com","123456");
        Optional<Tio> optTio = Optional.of(tio1);
        when(cuentaService.getOneById(1)).thenReturn(optTio);
        when(cuentaService.getFindById(1)).thenReturn(tio1);
        mvc.perform( MockMvcRequestBuilders
        .get("/tio/detalle/{id}", 1)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("ejemplo13711"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("ejemplo13711@ejemplo.com"));


        verify(cuentaService).getOneById(1);
    }

    @Test
    void testListar() throws Exception {
        // Given
       
        List<Tio> lista = new LinkedList<Tio>();
        Tio tio1 = new Tio(1,"ejemplo13711","ejemplo13711@gmail.com","123456");
        Tio tio2 = new Tio(2, "amiya", "amiya@gmail.com", "123456");
        Tio tio3 = new Tio(7, "ejemplo13712", "ejemplo13712@gmail.com", "123456");
        Tio tio4 = new Tio(8, "ejemplo13713", "ejemplo13713@gmail.com", "123456");
        lista.add(tio1);
        lista.add(tio2);
        lista.add(tio3);
        lista.add(tio4);
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

        //new ResponseEntity<List<Tio>>(list, HttpStatus.CREATED)
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
 */}

