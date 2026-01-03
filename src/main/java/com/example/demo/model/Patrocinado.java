package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Patrocinado")
public class Patrocinado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patrocinado")
    private Integer idPatrocinado;

    private String nombre;

    public Integer getIdPatrocinado() {
        return idPatrocinado;
    }

    public void setIdPatrocinado(Integer idPatrocinado) {
        this.idPatrocinado = idPatrocinado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
