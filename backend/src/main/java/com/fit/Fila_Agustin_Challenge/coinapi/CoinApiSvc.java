package com.fit.Fila_Agustin_Challenge.coinapi;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class CoinApiSvc {
    private static CoinApiSvc instancia = null;
    private static int maximaCantidadRegistrosDefault = 200;
    private static final String urlApi = "https://rest.coinapi.io/v1/";
    private static final String token = "CEA0B191-09B0-463E-B3CB-20B0749E4C43";
    private Retrofit retrofit;


    private CoinApiSvc() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static CoinApiSvc instancia(){
        if(instancia== null){
            instancia = new CoinApiSvc();
        }
        return instancia;
    }


    public List<Exchange> listarExchanges() throws IOException {
        CoinApiInt coinApiInt                       = this.retrofit.create(CoinApiInt.class);
        Call<List<Exchange>> requestExchanges       = coinApiInt.listarExchanges(token);
        Response<List<Exchange>> responseExchanges  = requestExchanges.execute();
        return responseExchanges.body();
    }
    public List<ExchangeIcon> listarIconosExchanges(String iconSize) throws IOException {
        CoinApiInt coinApiInt                           = this.retrofit.create(CoinApiInt.class);
        Call<List<ExchangeIcon>> requestExchanges       = coinApiInt.listarIconosExchanges(token, iconSize);
        Response<List<ExchangeIcon>> responseExchanges  = requestExchanges.execute();
        return responseExchanges.body();
    }

    public List<Asset> listarAssets() throws IOException {
        CoinApiInt coinApiInt                   = this.retrofit.create(CoinApiInt.class);
        Call<List<Asset>> requestAssets         = coinApiInt.listarAssets(token);
        Response<List<Asset>> responseAssets    = requestAssets.execute();
        return responseAssets.body();
    }

    public List<AssetIcon> listarIconosAssets(String iconSize) throws IOException {
        CoinApiInt coinApiInt                           = this.retrofit.create(CoinApiInt.class);
        Call<List<AssetIcon>> requestIconsAssets        = coinApiInt.listarIconosAssets(token, iconSize);
        Response<List<AssetIcon>> responseIconsAssets   = requestIconsAssets.execute();
        return responseIconsAssets.body();
    }

    public ExchangeRate buscarAssetExchangeRate(String idAssetBase, String idAssetQuote) throws IOException {
        CoinApiInt coinApiInt                       = this.retrofit.create(CoinApiInt.class);
        Call<ExchangeRate> requestExchangeRate      = coinApiInt.buscarAssetExchangeRate(token, idAssetBase, idAssetQuote);
        Response<ExchangeRate> responseExchangeRate = requestExchangeRate.execute();
        return responseExchangeRate.body();
    }
}
