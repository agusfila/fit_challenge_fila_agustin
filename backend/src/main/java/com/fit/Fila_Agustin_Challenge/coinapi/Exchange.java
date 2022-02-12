package com.fit.Fila_Agustin_Challenge.coinapi;

public class Exchange {
    private String exchange_id;
    private String website;
    private String name;
    private String data_start;
    private String data_end;
    private String data_quote_start;
    private String data_quote_end;
    private double data_symbols_count;
    private double volume_1hrs_usd;
    private double volume_1day_usd;
    private double volume_1mth_usd;

    public String getExchange_id() {
        return exchange_id;
    }

    public void setExchange_id(String exchange_id) {
        this.exchange_id = exchange_id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData_start() {
        return data_start;
    }

    public void setData_start(String data_start) {
        this.data_start = data_start;
    }

    public String getData_end() {
        return data_end;
    }

    public void setData_end(String data_end) {
        this.data_end = data_end;
    }

    public String getData_quote_start() {
        return data_quote_start;
    }

    public void setData_quote_start(String data_quote_start) {
        this.data_quote_start = data_quote_start;
    }

    public String getData_quote_end() {
        return data_quote_end;
    }

    public void setData_quote_end(String data_quote_end) {
        this.data_quote_end = data_quote_end;
    }

    public double getData_symbols_count() {
        return data_symbols_count;
    }

    public void setData_symbols_count(double data_symbols_count) {
        this.data_symbols_count = data_symbols_count;
    }

    public double getVolume_1hrs_usd() {
        return volume_1hrs_usd;
    }

    public void setVolume_1hrs_usd(double volume_1hrs_usd) {
        this.volume_1hrs_usd = volume_1hrs_usd;
    }

    public double getVolume_1day_usd() {
        return volume_1day_usd;
    }

    public void setVolume_1day_usd(double volume_1day_usd) {
        this.volume_1day_usd = volume_1day_usd;
    }

    public double getVolume_1mth_usd() {
        return volume_1mth_usd;
    }

    public void setVolume_1mth_usd(double volume_1mth_usd) {
        this.volume_1mth_usd = volume_1mth_usd;
    }
}
