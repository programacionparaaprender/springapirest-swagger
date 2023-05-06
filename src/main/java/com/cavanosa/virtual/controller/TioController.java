package com.cavanosa.virtual.controller;

import com.cavanosa.virtual.entity.Tio;
import com.cavanosa.virtual.dto.Mensaje;
import com.cavanosa.virtual.dto.TioDto;
import com.cavanosa.virtual.service.TioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Api(value = "TioController", description = "Api que gestiona los usuarios del sistema de prueba")
@RestController
@RequestMapping("/tio") //localhost:8080/usuarios
@CrossOrigin
@Controller
public class TioController {

    @Autowired
    TioService tioService;

    
    @ApiOperation(value = "Obtener usuarios del sistema ", notes = "Obtener usuarios del sistema")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "lista") })
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Tio>> lista(){
        List<Tio> list = tioService.findAll();
        return new ResponseEntity<List<Tio>>(list, HttpStatus.OK);
    }

    
    @ApiImplicitParams({
       @ApiImplicitParam(name = "getOne", required = true, value = "(Required) Title of the item.", dataType = "int")
    })
    @GetMapping("/detalle/{id}")
    public ResponseEntity<?> getOne(@ApiParam @PathVariable("id") Long id){
        if(!tioService.existsById(id))
            return getMensaje("no existe", HttpStatus.NOT_FOUND);
        Tio tio = tioService.getOneById(id).get();
        ResponseEntity<Tio> resultado = ResponseEntity.ok(tio);
        return resultado;
    }

    
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody TioDto tioDto, BindingResult bindingResult){
        //if(bindingResult.hasErrors())
        //    return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        try{
        	return logeo(tioDto);		
        }catch(Exception e){
        	return getMensaje("error en base de datos", HttpStatus.BAD_REQUEST);
        }

    }
    
    @PostMapping("/logeo")
    private ResponseEntity<?> logeo(TioDto tioDto){
        List<Tio> list2 = tioService.findAll();
        	List<Tio> list = new java.util.LinkedList<Tio>();
        	for(Tio temp: list2) {
        		boolean uno = temp.getNombre().equalsIgnoreCase(tioDto.getNombre());
        		boolean dos = temp.getPassword().equalsIgnoreCase(tioDto.getPassword());
        		if(uno && dos) {
        			list.add(temp);
        		}
        	}
            if(list.size() > 0) {
            	return new ResponseEntity<List<Tio>>(list, HttpStatus.OK);
            }else
            	return getMensaje("usuario no existe", HttpStatus.BAD_REQUEST);
    }



    public ResponseEntity<Mensaje> getMensaje(String mensaje, HttpStatus status){
        Mensaje msj = new Mensaje(mensaje);
        ResponseEntity<Mensaje> entity = new ResponseEntity<Mensaje>(msj, status);
        return entity;
    }

    @ApiOperation(value = "Crear nuevo Usuario", notes = "Crear nuevo Usuario del sistema")
    @RequestMapping(value = "/nuevo", method = RequestMethod.POST)
    public ResponseEntity<?> saveTio(@Valid @RequestBody TioDto tioDto, BindingResult bindingResult){
    	try{
    	    if(tioService.existsByNombre(tioDto.getNombre()))
                return getMensaje("ya existe ese nombre", HttpStatus.BAD_REQUEST);
            if(tioService.exixtsByEmail(tioDto.getEmail()))
                return getMensaje("ya existe ese email", HttpStatus.BAD_REQUEST);
            Tio tio = new Tio(tioDto.getNombre(), tioDto.getEmail(), tioDto.getPassword());
            tioService.save(tio);
            if(tioService.save(tio) == true) {
        	    return new ResponseEntity<Tio>(tio, HttpStatus.CREATED);
            }else
        	    return getMensaje("usuario no existe", HttpStatus.BAD_REQUEST);
    	}
        catch(Exception e){
        	return getMensaje("error en base de datos", HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Actualizar Usuarios", notes = "Enviar Usuarios a Actualizar", response = ResponseEntity.class)
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody TioDto tioDto, BindingResult bindingResult, @PathVariable("id") Long id){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        if(!tioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(tioService.existsByNombre(tioDto.getNombre()) && tioService.getOneByNombre(tioDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ya existe ese nombre"), HttpStatus.BAD_REQUEST);
        if(tioService.exixtsByEmail(tioDto.getEmail()) && tioService.getOneByEmail(tioDto.getEmail()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ya existe ese email"), HttpStatus.BAD_REQUEST);
        Tio tio = tioService.getOneById(id).get();
        tio.setNombre(tioDto.getNombre());
        tio.setEmail(tioDto.getEmail());
        tio.setPassword(tioDto.getPassword());
        tioService.save(tio);
        return new ResponseEntity(new Mensaje("tio actualizado"), HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar Usuarios", notes = "Enviar Usuarios a Eliminar", response = ResponseEntity.class)
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> deleteTio(@PathVariable("id") Long id){
        if(!tioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        tioService.delete(id);
        return new ResponseEntity(new Mensaje("tio eliminado"), HttpStatus.OK);
    }
}
