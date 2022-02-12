package com.fit.Fila_Agustin_Challenge.models;


import com.fit.Fila_Agustin_Challenge.coinapi.Asset;

public class AssetModel {
    private String asset_id;
    private String name;
    private double price_usd;
    private double rate_usd;
    private String url;

    public AssetModel(String asset_id, String name, double price_usd, double rate_usd, String url) {
        this.asset_id   = asset_id;
        this.name       = name;
        this.price_usd  = price_usd;
        this.rate_usd   = rate_usd;
        this.url        = url;
    }
}
