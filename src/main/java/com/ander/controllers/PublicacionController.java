package com.ander.controllers;

import org.springframework.web.bind.annotation.*;
import com.ander.services.PublicacionServiceImp;
import org.springframework.web.bind.annotation.PathVariable;
import com.ander.Dto.PublicacionDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {
    @Autowired PublicacionServiceImp publicacionServiceImp;

    @GetMapping("")
    public List<PublicacionDto> obtenerPublicaciones()
    {
        
        return publicacionServiceImp.obtenerPublicaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionDto> obtenerPublicacionPorId(@PathVariable(name = "id") Long id)
    {
        return new ResponseEntity<>(publicacionServiceImp.obtenerPublicacionPorId(id),HttpStatus.OK);
    }

    @PostMapping("/crearPublicacion")
    public ResponseEntity<PublicacionDto> crearPublicacion(@RequestBody PublicacionDto publicacionDto){
        
        return new ResponseEntity<>(publicacionServiceImp.crearPublicacion(publicacionDto),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicacionDto> editarPublicacion(@PathVariable(name = "id") Long id,@RequestBody PublicacionDto publicacionDto)
    {
        return new ResponseEntity<>(publicacionServiceImp.editarPublicacion(id,publicacionDto),HttpStatus.OK);
    }   
    @DeleteMapping("/{id}")
    public ResponseEntity<String> elimianrPublicacionPorId(@PathVariable(name = "id") Long id)
    {
        publicacionServiceImp.eliminarPublicaionPorId(id);
        return new ResponseEntity<>(String.format("Se elimino la publicacion con id %s", id),HttpStatus.OK);
    }   
}