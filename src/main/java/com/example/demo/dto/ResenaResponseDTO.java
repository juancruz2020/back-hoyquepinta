package com.example.demo.dto;


public class ResenaResponseDTO {

    private Integer idResena;
    private Integer estrellas;
    private String descripcion;
    private Integer idEvento;
    private String nombreUsuario;

    public ResenaResponseDTO() {
    }

    public ResenaResponseDTO(Integer idResena, Integer estrellas, String descripcion,
                             Integer idEvento, String nombreUsuario) {
        this.idResena = idResena;
        this.estrellas = estrellas;
        this.descripcion = descripcion;
        this.idEvento = idEvento;
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getIdResena() {
        return idResena;
    }

    public void setIdResena(Integer idResena) {
        this.idResena = idResena;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
