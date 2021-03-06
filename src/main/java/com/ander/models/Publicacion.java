package com.ander.models;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.SQLDelete;


@Entity
@Table(name = "publicaciones",schema="blogzada",uniqueConstraints={
    @UniqueConstraint(columnNames={"titulo"}),
    @UniqueConstraint(columnNames = {"contenido"}) 
})

public class Publicacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="titulo", nullable=false)

    private String nombre;
    @Column(name="descripcion", nullable=false)
    private String descripcion;
    @Column(name="contenido",nullable=false)
    private String contenido;
    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comentario> comentarios = new HashSet<>();
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public Publicacion() {
    }
    public Publicacion(Long id, String nombre, String descripcion, String contenido) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.contenido = contenido;
    }
    
}
