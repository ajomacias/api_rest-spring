package com.ander.excepciones;

import org.springframework.http.HttpStatus;

public class BlogAlppException extends RuntimeException{
    private HttpStatus status;
    private String mensaje;

    public BlogAlppException(HttpStatus status, String mensaje) {
        super();
        this.status = status;
        this.mensaje = mensaje;
    }

    public BlogAlppException(HttpStatus status, String mensaje, String mensaje1) {
        super();
        this.status = status;
        this.mensaje = mensaje;
        this.mensaje = mensaje1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    

    
    
}
