package com.fit.Fila_Agustin_Challenge.models;

import com.fit.Fila_Agustin_Challenge.coinapi.Exchange;

public class ExchangeModel {
    private String exchange_id;
    private String website;
    private String name;
    private Double comision;
    private String url;

    public ExchangeModel(String exchange_id, String website, String name, Double comision, String url) {
        this.exchange_id = exchange_id;
        this.website = website;
        this.name = name;
        this.comision = comision;
        this.url = url;
    }
}
