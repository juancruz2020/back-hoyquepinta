package com.example.demo.dto;

public class BusquedaDTO {

    private int id_patrocinado;
    private int id_ubicacion;
    private int id_categoria;

    public void setId_patrocinado(int id_patrocinado) {
        this.id_patrocinado = id_patrocinado;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_patrocinado() {
        return id_patrocinado;
    }

    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public int getId_categoria() {
        return id_categoria;
    }
}
