package com.example.demo.dto;

public class ModificarUsuarioDTO {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String mail;
    private Integer edad;

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getMail() {
        return mail;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
}
