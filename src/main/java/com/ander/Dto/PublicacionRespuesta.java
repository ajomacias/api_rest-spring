package com.ander.Dto;

import com.ander.Dto.PublicacionDto;

import java.util.List;

public class PublicacionRespuesta {
    private List<PublicacionDto> contenido;
    private Long totalElementos;
    private int numeroPagina;
    private int medidaagina;
    private boolean ultima;
    public List<PublicacionDto> getContenido() {
        return contenido;
    }
    public void setContenido(List<PublicacionDto> contenido) {
        this.contenido = contenido;
    }
    public Long getTotalElementos() {
        return totalElementos;
    }
    public void setTotalElementos(Long totalElementos) {
        this.totalElementos = totalElementos;
    }
    public int getNumeroPagina() {
        return numeroPagina;
    }
    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }
    public int getMedidaagina() {
        return medidaagina;
    }
    public void setMedidaagina(int medidaagina) {
        this.medidaagina = medidaagina;
    }
    public boolean isUltima() {
        return ultima;
    }
    public void setUltima(boolean ultima) {
        this.ultima = ultima;
    }
    
}
