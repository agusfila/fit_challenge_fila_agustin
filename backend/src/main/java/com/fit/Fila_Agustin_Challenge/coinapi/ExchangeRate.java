package com.fit.Fila_Agustin_Challenge.coinapi;

import java.util.Date;

public class ExchangeRate {
    private Date time;
    private String asset_id_base;
    private String asset_id_quote;
    private Double rate;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAsset_id_base() {
        return asset_id_base;
    }

    public void setAsset_id_base(String asset_id_base) {
        this.asset_id_base = asset_id_base;
    }

    public String getAsset_id_quote() {
        return asset_id_quote;
    }

    public void setAsset_id_quote(String asset_id_quote) {
        this.asset_id_quote = asset_id_quote;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
