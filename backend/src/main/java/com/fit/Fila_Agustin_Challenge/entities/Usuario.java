package com.fit.Fila_Agustin_Challenge.entities;

import com.fit.Fila_Agustin_Challenge.entities.Persistente;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario extends Persistente {
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "clave")
    private String clave;

    public Usuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public Usuario() {

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
