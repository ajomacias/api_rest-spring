package com.ander.Dto;

import java.util.List;

public class PublicacionRespuesta {
    private List<PublicacionDto> contenido;
    
    private int numeroPagina;
    private int medidagina;
    private Long totalElementos;
    private int totalPaginas;
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
    public int getMedidagina() {
        return medidagina;
    }
    public void setMedidagina(int medidaagina) {
        this.medidagina = medidaagina;
    }
    public boolean isUltima() {
        return ultima;
    }
    public int getTotalPaginas() {
        return totalPaginas;
    }
    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }
    public void setUltima(boolean ultima) {
        this.ultima = ultima;
    }
    
}
