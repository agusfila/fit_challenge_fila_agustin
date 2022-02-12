package com.fit.Fila_Agustin_Challenge.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Compra")
public class Compra extends Persistente {
    @OneToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "assetId")
    private String assetId;

    @Column(name = "exchangeId")
    private String exchangeId;

    @Column(name = "costoTotal")
    private Double costoTotal;

    @Column(name = "cantidad")
    private Double cantidad;

    @Column(name = "fecha", columnDefinition = "DATETIME")
    private Date fecha;

    @Column(name = "valorUnitarioUSD")
    private Double valorUnitarioUSD;

    public Double getComisionTotal() {
        return comisionTotal;
    }

    public void setComisionTotal(Double comisionTotal) {
        this.comisionTotal = comisionTotal;
    }

    @Column(name = "comisionTotal")
    private Double comisionTotal;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getValorUnitarioUSD() {
        return valorUnitarioUSD;
    }

    public void setValorUnitarioUSD(Double valorUnitarioUSD) {
        this.valorUnitarioUSD = valorUnitarioUSD;
    }
}
