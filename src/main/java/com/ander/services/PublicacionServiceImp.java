package com.ander.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.ander.Dto.PublicacionDto;
import com.ander.excepciones.ResourceNotFound;
import com.ander.excepciones.ResourceVioledConstraint;
import com.ander.models.Publicacion;
import com.ander.repository.PublicacionesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class PublicacionServiceImp implements PublicacionServices{

    @Autowired PublicacionesRepository publicacionRepository;

    @Override
    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto){
        //Convertimos Dto a entidad
        Publicacion publicacion = mapearPublicacion(publicacionDto);
        Publicacion nuevaPublicacion = null;
        try{
        publicacionRepository.save(publicacion);
        }catch(DataIntegrityViolationException err){
            throw new ResourceVioledConstraint("publicacion", "unique",
            publicacionDto.getContenido(),publicacionDto.getTitulo());
        }

        //Covertimos de entidad a DTO

        return mapearDto(nuevaPublicacion);
    }
    @Override
    public PublicacionDto editarPublicacion(Long id,PublicacionDto publicacionDto)
    {
        Publicacion publicacion = publicacionRepository.findById(id)
        .orElseThrow(()->new ResourceNotFound(id, "id", "publicacion"));
        
        publicacion.setNombre(publicacionDto.getTitulo());
        publicacion.setDescripcion(publicacionDto.getDescripcion());
        publicacion.setContenido(publicacionDto.getContenido());

        return mapearDto(publicacion);
    }

    @Override
    public void eliminarPublicaionPorId(Long id)
    {
       Publicacion publicacion = publicacionRepository.findById(id)
       .orElseThrow(()-> new ResourceNotFound(id, "id", "publicacion"));

       publicacionRepository.delete(publicacion);

    }
    @Override
    public List<PublicacionDto> obtenerPublicaciones() 
    {
        List<Publicacion> publicaciones = publicacionRepository.findAll();
        return publicaciones.stream().map(publicacion->mapearDto(publicacion)).collect(Collectors.toList());
    }
    @Override
    public PublicacionDto obtenerPublicacionPorId(Long id)
    {
        Publicacion publicacion = publicacionRepository.findById(id).orElseThrow(()->new ResourceNotFound(id, "id", "publicacion"));
        return mapearDto(publicacion);
    }

    private PublicacionDto mapearDto(Publicacion publicacion)
    {
        PublicacionDto publicacionDto = new PublicacionDto();
        publicacionDto.setId(publicacion.getId());
        publicacionDto.setTitulo(publicacion.getNombre());
        publicacionDto.setDescripcion(publicacion.getDescripcion());
        publicacionDto.setContenido(publicacion.getContenido());

        return publicacionDto;
    }

    private Publicacion mapearPublicacion(PublicacionDto publicacionDto)
    {
        Publicacion publicacion = new Publicacion();
        publicacion.setContenido(publicacionDto.getContenido());
        publicacion.setDescripcion(publicacionDto.getDescripcion());
        publicacion.setNombre(publicacionDto.getTitulo());

        return publicacion;
    } 
}
