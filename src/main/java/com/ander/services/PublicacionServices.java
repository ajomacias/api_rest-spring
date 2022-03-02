package com.ander.services;

import com.ander.Dto.PublicacionDto;

import java.util.List;

public interface PublicacionServices {
    public PublicacionDto crearPublicacion(PublicacionDto PublicacionDto);

    public PublicacionDto editarPublicacion(Long id,PublicacionDto publicacionDto);

    public List<PublicacionDto> obtenerPublicaciones();

    public PublicacionDto obtenerPublicacionPorId(Long id);

    public void eliminarPublicaionPorId(Long id);
}
