package com.example.demo.dto;

import com.example.demo.model.TipoUsuario;

public class RegistroUsuarioDTO {


    private String nombre;
    private String apellido;
    private String mail;
    private String contrasena;
    private Integer edad;
    private Integer dni;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMail() {
        return mail;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getDni() {
        return dni;
    }
}
