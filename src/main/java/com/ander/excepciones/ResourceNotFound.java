package com.ander.excepciones;

import java.lang.RuntimeException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{

    private String nombreDelRecurso;
    private String nombreDelCampo;
    private Long valorDelCampo;

    public ResourceNotFound(Long id,String nombreDelCampo,String nombreRecurso){
        super(String.format("%s no encontrado con : %s : %s", nombreRecurso,nombreDelCampo,id));
        this.nombreDelCampo = nombreDelCampo;
        this.nombreDelRecurso = nombreRecurso;
        this.valorDelCampo = id;
    }

    public String getNombreDelRecurso() {
        return nombreDelRecurso;
    }

    public void setNombreDelRecurso(String nombreDelRecurso) {
        this.nombreDelRecurso = nombreDelRecurso;
    }

    public String getNombreDelCampo() {
        return nombreDelCampo;
    }

    public void setNombreDelCampo(String nombreDelCampo) {
        this.nombreDelCampo = nombreDelCampo;
    }

    public Long getValorDelCampo() {
        return valorDelCampo;
    }

    public void setValorDelCampo(Long valorDelCampo) {
        this.valorDelCampo = valorDelCampo;
    }



    
}