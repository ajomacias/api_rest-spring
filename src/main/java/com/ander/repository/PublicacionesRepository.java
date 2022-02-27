package com.ander.repository;

import com.ander.models.Publicacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionesRepository extends JpaRepository<Publicacion,Long>{
    
}
