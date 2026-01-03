package com.example.demo.dto;

public class ResenaDTO {

    private Integer estrellas;
    private Integer idEvento;
    private Integer idUsuario;
    private String descripcion;

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
