package com.ander.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ander.services.ComentarioServiceImp;
import com.ander.Dto.ComentarioDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ComentarioController{

    @Autowired
    private ComentarioServiceImp comentarioService;

    @GetMapping("/publicaciones/{publicacionId}/comentarios")
    public List<ComentarioDTO> obtenerComentariosPublicacion(@PathVariable(name = "publicacionId") Long publicacionId)
    {
        return comentarioService.obtenerComentariosPorPublicacion(publicacionId);
    }

    @GetMapping("/publicaciones/{publicacionId}/comentarios/{id}")
    public ResponseEntity<ComentarioDTO> obtenerComentario(@PathVariable(name = "publicacionId") Long publicacionId, @PathVariable(name="id")Long id )
    {  
        ComentarioDTO comentarioDTO = comentarioService.obtenerComentarioPorId(publicacionId, id);
        return new ResponseEntity<>(comentarioDTO,HttpStatus.OK);
    }


    @PostMapping("/publicaciones/{publicacionId}/comentarios")

    public ResponseEntity<ComentarioDTO> guardarComentario(@PathVariable(name = "publicacionId") Long publicacionID, 
    @RequestBody ComentarioDTO comentarioDTO)
    {
        return new ResponseEntity<>(comentarioService.crearComentario(publicacionID, comentarioDTO) ,HttpStatus.CREATED);
    }
}