package com.fit.Fila_Agustin_Challenge.models;

public class CalcularPrecio {
    private Double valorUnitarioUSD;
    private Double cantidad;
    private Double comision;

    public CalcularPrecio(Double valorUnitarioUSD, Double cantidad, Double comision) {
        this.valorUnitarioUSD = valorUnitarioUSD;
        this.cantidad = cantidad;
        this.comision = comision;
    }

    public Double getValorUnitarioUSD() {
        return valorUnitarioUSD;
    }

    public void setValorUnitarioUSD(Double valorUnitarioUSD) {
        this.valorUnitarioUSD = valorUnitarioUSD;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }
}
