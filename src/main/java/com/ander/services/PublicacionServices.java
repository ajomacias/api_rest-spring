package com.ander.services;

import com.ander.Dto.PublicacionDto;
import com.ander.Dto.PublicacionRespuesta;


public interface PublicacionServices {
    public PublicacionDto crearPublicacion(PublicacionDto PublicacionDto);

    public PublicacionDto editarPublicacion(Long id,PublicacionDto publicacionDto);

    public PublicacionRespuesta obtenerPublicaciones(int numeroPag, int medidaPagina);

    public PublicacionDto obtenerPublicacionPorId(Long id);

    public void eliminarPublicaionPorId(Long id);
}
