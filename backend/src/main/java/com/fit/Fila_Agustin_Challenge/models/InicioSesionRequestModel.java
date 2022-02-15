package com.fit.Fila_Agustin_Challenge.models;

public class InicioSesionRequestModel {
    private String nombreUsuario;
    private String clave;

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
