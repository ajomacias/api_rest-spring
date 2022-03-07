package com.ander.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.ander.Dto.ComentarioDTO;
import com.ander.excepciones.BlogAlppException;
import com.ander.excepciones.ResourceNotFound;
import com.ander.models.Comentario;
import com.ander.models.Publicacion;
import com.ander.repository.ComentarioRepository;
import com.ander.repository.PublicacionesRepository;

@Service
public class ComentarioServiceImp implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired 
    private PublicacionesRepository publicacionesRepository;

    @Override
    public ComentarioDTO crearComentario(Long idPublicacion, ComentarioDTO comentarioDTO) {
        Comentario comentario = mapearEntidad(comentarioDTO);

        Publicacion publicacion = publicacionesRepository.findById(idPublicacion)
        .orElseThrow(()-> new ResourceNotFound(idPublicacion, "id", "publicacion"));

        comentario.setPublicacion(publicacion);

        Comentario nuevoComentario = comentarioRepository.save(comentario);
        
        return mapearDTO(nuevoComentario);
    }


    private ComentarioDTO mapearDTO(Comentario comentario)
    {
        ComentarioDTO comentarioDTO = new ComentarioDTO();
        comentarioDTO.setId(comentario.getId());
        comentarioDTO.setNombre(comentario.getNombre());
        comentarioDTO.setCuerpo(comentario.getCuerpo());
        comentarioDTO.setEmail(comentario.getEmail());

        return comentarioDTO;

    }

    private Comentario mapearEntidad(ComentarioDTO comentarioDTO){

        Comentario comentario = new Comentario();
        comentario.setId(comentarioDTO.getId());
        comentario.setNombre(comentarioDTO.getNombre());
        comentario.setCuerpo(comentarioDTO.getCuerpo());
        comentario.setEmail(comentarioDTO.getEmail());

        return comentario;

    }

    @Override
    public List<ComentarioDTO> obtenerComentariosPorPublicacion(Long publicacionId) {
        List<Comentario> listComentarios = comentarioRepository.findByPublicacionId(publicacionId);
        
        return listComentarios.stream().map(comentario->mapearDTO(comentario)).collect(Collectors.toList());
    }


    @Override
    public ComentarioDTO obtenerComentarioPorId(Long publicacionId,Long id) {
        Publicacion publicacion = publicacionesRepository.findById(publicacionId)
        .orElseThrow(()-> new ResourceNotFound(publicacionId, "id", "publicacion"));

        Comentario comentario = comentarioRepository.findById(id)
        .orElseThrow(()->new ResourceNotFound(id, "id", "comentario"));

        if(!comentario.getPublicacion().getId().equals(publicacion.getId()))
        {
            throw new BlogAlppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicacion");
        }

        return mapearDTO(comentario);
    }
    
}
