package com.ander.services;

import org.springframework.stereotype.Service;

import com.ander.Dto.PublicacionDto;
import com.ander.models.Publicacion;
import com.ander.repository.PublicacionesRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PublicacionServiceImp implements PublicacionServices{

    @Autowired PublicacionesRepository publicacionRepository;

    @Override
    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto){
        //Convertimos Dto a entidad
        Publicacion publicacion = new Publicacion();
        publicacion.setContenido(publicacionDto.getContenido());
        publicacion.setDescripcion(publicacionDto.getDescripcion());
        publicacion.setNombre(publicacionDto.getTitulo());

        Publicacion nuevaPublicacion = publicacionRepository.save(publicacion);

        //Covertimos de entidad a DTO

        PublicacionDto publiacionDtoRespuesta = new PublicacionDto();
        publiacionDtoRespuesta.setId(nuevaPublicacion.getId());
        publiacionDtoRespuesta.setTitulo(nuevaPublicacion.getNombre());
        publiacionDtoRespuesta.setDescripcion(nuevaPublicacion.getDescripcion());
        publiacionDtoRespuesta.setContenido(nuevaPublicacion.getContenido());

        return publiacionDtoRespuesta;
    }
    @Override
    public PublicacionDto editarPublicacion(PublicacionDto publicacionDto)
    {
        Publicacion publicacion = new Publicacion();
        publicacion.setId(publicacionDto.getId());
        publicacion.setNombre(publicacionDto.getTitulo());
        publicacion.setDescripcion(publicacionDto.getDescripcion());
        publicacion.setContenido(publicacionDto.getContenido());

        Publicacion publicacionEditada = publicacionRepository.save(publicacion);
        PublicacionDto publicacionRespuesta = new PublicacionDto();
        publicacionRespuesta.setId(publicacionEditada.getId());
        publicacionRespuesta.setTitulo(publicacionEditada.getNombre());
        publicacionRespuesta.setDescripcion(publicacionEditada.getDescripcion());
        publicacionRespuesta.setContenido(publicacionEditada.getContenido());

        return publicacionRespuesta;

    }   

    
}
