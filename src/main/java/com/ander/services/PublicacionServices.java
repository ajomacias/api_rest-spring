package com.ander.services;

import com.ander.Dto.PublicacionDto;

public interface PublicacionServices {
    public PublicacionDto crearPublicacion(PublicacionDto PublicacionDto);

    public PublicacionDto editarPublicacion(PublicacionDto publicacionDto);
}
