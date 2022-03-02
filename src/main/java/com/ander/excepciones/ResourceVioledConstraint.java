package com.ander.excepciones;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value =HttpStatus.CONFLICT)
public class ResourceVioledConstraint extends RuntimeException {

    String nombreRecurso;
    String tipoConstraint;
    String valor1;
    String valor2;
    String valor3;
    

    public ResourceVioledConstraint(String nombreRecurso, String tipoConstraint, String valor1) {
        super(String.format("El valor ''%s'' de %s viola la constraint %s",valor1,nombreRecurso,tipoConstraint));
        this.nombreRecurso = nombreRecurso;
        this.tipoConstraint = tipoConstraint;
        this.valor1 = valor1;
    }
    
    public ResourceVioledConstraint(String nombreRecurso, String tipoConstraint, String valor1,
            String valor2) {
        super(String.format("El valor ``%s`` o ``%s`` de %s viola la constraint %s"
        ,valor1,valor2,nombreRecurso,tipoConstraint));
        this.nombreRecurso = nombreRecurso;
        this.tipoConstraint = tipoConstraint;
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
    

    public ResourceVioledConstraint(String nombreRecurso, String tipoConstraint, String valor1,
            String valor2, String valor3) {
        super(String.format("El valor ``%s`` o ``%s`` o ``%s`` de %s viola la constraint %s"
        ,valor1,valor2,valor3,nombreRecurso,tipoConstraint));
        this.nombreRecurso = nombreRecurso;
        this.tipoConstraint = tipoConstraint;
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }
    public String getTipoConstraint() {
        return tipoConstraint;
    }
    public String getValor1() {
        return valor1;
    }
    public String getValor2() {
        return valor2;
    }
    public String getValor3() {
        return valor3;
    }
    
}
