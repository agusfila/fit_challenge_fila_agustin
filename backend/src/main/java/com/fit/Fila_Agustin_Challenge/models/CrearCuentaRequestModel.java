package com.fit.Fila_Agustin_Challenge.models;

public class CrearCuentaRequestModel {
    private String nombre;
    private String apellido;
    private String mail;
    private String nombreUsuario;
    private String clave;

    public CrearCuentaRequestModel(String nombre, String apellido, String mail, String nombreUsuario, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
