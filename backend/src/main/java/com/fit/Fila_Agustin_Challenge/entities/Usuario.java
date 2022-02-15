package com.fit.Fila_Agustin_Challenge.entities;

import com.fit.Fila_Agustin_Challenge.entities.Persistente;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario extends Persistente {
    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "clave")
    private String clave;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "mail")
    private String mail;

    public Usuario(String nombreUsuario, String clave, String nombre, String appelido, String mail) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = appelido;
        this.mail = mail;
    }

    public Usuario() {

    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String usuario) {
        this.nombreUsuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
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

    public void setApellido(String appelido) {
        this.apellido = appelido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
