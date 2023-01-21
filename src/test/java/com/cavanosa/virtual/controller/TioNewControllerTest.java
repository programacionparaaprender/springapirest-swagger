package com.cavanosa.virtual.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.RequestBodySpec;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import com.cavanosa.virtual.dto.Mensaje;
import com.cavanosa.virtual.dto.TioDto;
import com.cavanosa.virtual.entity.Tio;
import com.cavanosa.virtual.service.TioService;


@SpringBootTest
@AutoConfigureWebTestClient(timeout = "20000")
@ExtendWith(MockitoExtension.class)
class TioNewControllerTest {
 
    @MockBean
    TioService tioService;
    
    //@MockBean
    //TioController tioController;
    
    @Autowired
    private WebTestClient webClient;

    @BeforeAll
    public static void setUp() {

    }
    
    @Order(1)
    @Test
    void obtenerIdTest(){
        int id = 2;
        Tio esperado = new Tio(2,"amiya", "amiya@gmail.com", "123456");
        when(tioService.getOneById(id).get()).thenReturn(esperado);
        this.webClient.get()
        .uri("/tio/detalle/" + id)
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()      
        .expectBody(Tio.class)
        .consumeWith(response -> {
            Tio resultado = response.getResponseBody();
            assertEquals(esperado, resultado);
        });
    }
    
    @Order(2)
    @Test
    void logeoTest(){
        List<Tio> lista = new LinkedList<Tio>();
        Tio tio1 = new Tio(1,"ejemplo13711","ejemplo13711@gmail.com","123456");
        Tio tio2 = new Tio(2,"amiya","amiya@gmail.com","123456");
        Tio tio3 = new Tio(7,"ejemplo13712","ejemplo13712@gmail.com","123456");
        lista.add(tio1);
        lista.add(tio2);
        lista.add(tio3);
        
        TioDto tioDto = new TioDto("amiya", "amiya@gmail.com", "123456");
        
        when(tioService.findAll()).thenReturn(lista);
        
        List<Tio> list2 = tioService.findAll();
        List<Tio> list = new java.util.LinkedList<Tio>();
        for(Tio temp: list2) {
            boolean uno = temp.getNombre().equalsIgnoreCase(tioDto.getNombre());
            boolean dos = temp.getPassword().equalsIgnoreCase(tioDto.getPassword());
            if(uno && dos) {
                list.add(temp);
            }
        }
        ResponseEntity<?> esperado = new ResponseEntity<List<Tio>>(list, HttpStatus.OK);
        ((RequestBodySpec) this.webClient.get()
        .uri("/tio/logeo")
        .accept(MediaType.APPLICATION_JSON))
        .body(BodyInserters.fromValue(tioDto))
        .exchange()
        .expectStatus().isOk()      
        .expectBody(ResponseEntity.class)
        .consumeWith(response -> {
            ResponseEntity<?> resultado = response.getResponseBody();
            assertEquals(esperado, resultado);
        });
    }

    @Order(3)
    @Test
    void loginTest(){
        List<Tio> lista = new LinkedList<Tio>();
        Tio tio1 = new Tio(1,"ejemplo13711","ejemplo13711@gmail.com","123456");
        Tio tio2 = new Tio(2,"amiya","amiya@gmail.com","123456");
        Tio tio3 = new Tio(7,"ejemplo13712","ejemplo13712@gmail.com","123456");
        lista.add(tio1);
        lista.add(tio2);
        lista.add(tio3);
        
        TioDto tioDto = new TioDto("amiya", "amiya@gmail.com", "123456");
        
        when(tioService.findAll()).thenReturn(lista);
        
        List<Tio> list2 = tioService.findAll();
        List<Tio> list = new java.util.LinkedList<Tio>();
        for(Tio temp: list2) {
            boolean uno = temp.getNombre().equalsIgnoreCase(tioDto.getNombre());
            boolean dos = temp.getPassword().equalsIgnoreCase(tioDto.getPassword());
            if(uno && dos) {
                list.add(temp);
            }
        }
        ResponseEntity<?> esperado = new ResponseEntity<List<Tio>>(list, HttpStatus.OK);
        ((RequestBodySpec) this.webClient.get()
        .uri("/tio/login")
        .accept(MediaType.APPLICATION_JSON))
        .body(BodyInserters.fromValue(tioDto))
        .exchange()
        .expectStatus().isOk()      
        .expectBody(ResponseEntity.class)
        .consumeWith(response -> {
            ResponseEntity<?> resultado = response.getResponseBody();
            assertEquals(esperado, resultado);
        });
    }
    
    
   /*  
    @Order(4)
    @Test
    void getMensajeTest(){
        //tioController
        String mensaje="Todo bien";
        HttpStatus status = HttpStatus.OK;
        Mensaje men = new Mensaje(mensaje); 
        ResponseEntity<Mensaje> mensajeEntity = new ResponseEntity<Mensaje>(men, status);
        when(tioController.getMensaje(mensaje, status)).thenReturn(mensajeEntity);
        ResponseEntity<Mensaje> respuesta = tioController.getMensaje(mensaje, status);
        assertEquals(mensajeEntity, respuesta);
        verify(tioController).getMensaje(mensaje, status);
    }
 */
    
    
    @Order(5)
    @Test
    void metodoPrueba() {
        Tio tio1 = new Tio(1,"ejemplo13711","ejemplo13711@gmail.com","123456");
        Tio tio2 = new Tio(2, "amiya", "amiya@gmail.com", "123456");
        Tio tio3 = new Tio(7, "ejemplo13712", "ejemplo13712@gmail.com", "123456");
        Tio tio4 = new Tio(8, "ejemplo13713", "ejemplo13713@gmail.com", "123456");
        List<Tio> lista = new LinkedList<Tio>();
        lista.add(tio1);
        lista.add(tio2);
        lista.add(tio3);
        lista.add(tio4);
        when(tioService.findAll()).thenReturn(lista);
        this.webClient.get()
        .uri("/tio/lista")
        .accept(MediaType.APPLICATION_JSON)
        //.header("", "")
        .exchange()
        .expectStatus().isOk()      
        .expectBody(List.class)
        .consumeWith(response -> {
            List<Tio> listaResponse = response.getResponseBody();
            assertEquals(lista, listaResponse);
        });
    }

    @Order(6)
    @Test
    void indexPostTest() {
        Tio tio = new Tio("Nombre de prueba", "email@email.com", "123456");
        tioService.save(tio);
        when(tioService.save(tio)).thenReturn(true);
        this.webClient.post()
            .uri("/tio/nuevo")
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(tio))
            .exchange()
            .expectStatus().isEqualTo(HttpStatus.CREATED)
            .expectBody(Boolean.class)
            .isEqualTo(true);
    }

    

}