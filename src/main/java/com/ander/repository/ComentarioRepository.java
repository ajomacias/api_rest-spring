package com.ander.repository;

import com.ander.models.Comentario;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    public List<Comentario> findByPublicacionId(Long id);
    
}
