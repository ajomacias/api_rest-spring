package com.ander.services;

import com.ander.Dto.ComentarioDTO;
import java.util.List;

public interface ComentarioService {

    public ComentarioDTO crearComentario(Long idPublicacion , ComentarioDTO comentarioDTO);

    public List<ComentarioDTO> obtenerComentariosPorPublicacion(Long publicacionId);

    public ComentarioDTO obtenerComentarioPorId(Long publicaciomid,Long id);
    
}
