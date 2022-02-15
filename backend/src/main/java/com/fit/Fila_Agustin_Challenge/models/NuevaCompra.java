package com.fit.Fila_Agustin_Challenge.models;

public class NuevaCompra {
    private String idUsuario;
    private String asset_id;
    private String exchange_id;
    private Double comision;
    private Double cantidad;
    private Double valorUnitarioUSD;
    private Double cantidadDolar;

    public NuevaCompra(String idUsuario, String asset_id, String exchange_id, Double comision, Double cantidad, Double valorUnitarioUSD, Double cantidadDolar) {
        this.idUsuario = idUsuario;
        this.asset_id = asset_id;
        this.exchange_id = exchange_id;
        this.comision = comision;
        this.cantidad = cantidad;
        this.valorUnitarioUSD = valorUnitarioUSD;
        this.cantidadDolar = cantidadDolar;
    }

    public Double getCantidadDolar() {
        return cantidadDolar;
    }

    public void setCantidadDolar(Double cantidadDolar) {
        this.cantidadDolar = cantidadDolar;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(String asset_id) {
        this.asset_id = asset_id;
    }

    public String getExchange_id() {
        return exchange_id;
    }

    public void setExchange_id(String exchange_id) {
        this.exchange_id = exchange_id;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorUnitarioUSD() {
        return valorUnitarioUSD;
    }

    public void setValorUnitarioUSD(Double valorunitarioUSD) {
        this.valorUnitarioUSD = valorunitarioUSD;
    }
}
