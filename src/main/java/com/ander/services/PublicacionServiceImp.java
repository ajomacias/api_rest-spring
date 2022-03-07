package com.ander.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.ander.Dto.PublicacionDto;
import com.ander.Dto.PublicacionRespuesta;
import com.ander.excepciones.ResourceNotFound;
import com.ander.excepciones.ResourceVioledConstraint;
import com.ander.models.Publicacion;
import com.ander.repository.PublicacionesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.*;

@Service 
public class PublicacionServiceImp implements PublicacionServices{

    @Autowired 
    private PublicacionesRepository publicacionRepository;

    @Override
    public PublicacionRespuesta obtenerPublicaciones(int numeroPag,int medidaPagina, String ordenarPor,String sortDir) 
    {
        System.out.println(Sort.Direction.ASC.name());
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroPag,medidaPagina,sort);
        Page<Publicacion> publicaciones = publicacionRepository.findAll(pageable);
        
        List<Publicacion> listaPublicaciones = publicaciones.getContent();
        List<PublicacionDto> listaDto = listaPublicaciones.stream().map(publicacion->mapearDto(publicacion)).collect(Collectors.toList());
        PublicacionRespuesta publicacionRespuesta = new PublicacionRespuesta();
        publicacionRespuesta.setContenido(listaDto);
        publicacionRespuesta.setNumeroPagina(publicaciones.getNumber());
        publicacionRespuesta.setMedidagina(publicaciones.getSize());
        publicacionRespuesta.setTotalElementos(publicaciones.getTotalElements());
        publicacionRespuesta.setUltima(publicaciones.isLast());
        publicacionRespuesta.setTotalPaginas(publicaciones.getTotalPages());

        return publicacionRespuesta;
    }
    @Override
    public PublicacionDto obtenerPublicacionPorId(Long id)
    {
        Publicacion publicacion = publicacionRepository.findById(id).orElseThrow(()->new ResourceNotFound(id, "id", "publicacion"));
        return mapearDto(publicacion);
    }

    @Override
    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto){
        //Convertimos Dto a entidad
        Publicacion publicacion = mapearPublicacion(publicacionDto);
        try{
        publicacion = publicacionRepository.save(publicacion);

        }catch(DataIntegrityViolationException err){
            throw new ResourceVioledConstraint("publicacion", "unique",
            publicacionDto.getContenido(),publicacionDto.getTitulo());
        }

        //Covertimos de entidad a DTO
        return mapearDto(publicacion);
        
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
