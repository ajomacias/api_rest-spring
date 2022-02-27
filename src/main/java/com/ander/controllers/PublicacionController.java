package com.ander.controllers;

import org.springframework.web.bind.annotation.*;
import com.ander.services.PublicacionServiceImp;
import com.ander.Dto.PublicacionDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {
    @Autowired PublicacionServiceImp publicacionServiceImp;

    @GetMapping("")
    public String[] ll(@RequestHeader String lol){
        String[] d = {lol};
        return d;
    }

    @PostMapping("/crearPublicacion")
    public ResponseEntity<PublicacionDto> holaMundo(@RequestBody PublicacionDto publicacionDto){
        
        return new ResponseEntity<>(publicacionServiceImp.crearPublicacion(publicacionDto),HttpStatus.CREATED);
    }
    
}
