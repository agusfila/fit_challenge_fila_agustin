package com.fit.Fila_Agustin_Challenge.coinapi;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface CoinApiInt {

    @GET("assets")
    Call<List<Asset>> listarAssets(@Header("X-CoinAPI-Key") String token);

    @GET("assets/icons/{icon_size}")
    Call<List<AssetIcon>> listarIconosAssets(@Header("X-CoinAPI-Key") String token, @Path("icon_size") String iconSize);

    @GET("exchanges")
    Call<List<Exchange>> listarExchanges(@Header("X-CoinAPI-Key") String token);

    @GET("exchanges/icons/{icon_size}")
    Call<List<ExchangeIcon>> listarIconosExchanges(@Header("X-CoinAPI-Key") String token, @Path("icon_size") String iconSize);

    @GET("exchangerate/{asset_id_base}/{asset_id_quote}")
    Call<ExchangeRate> buscarAssetExchangeRate(@Header("X-CoinAPI-Key") String token, @Path("asset_id_base") String asset_id_base, @Path("asset_id_quote") String asset_id_quote);
}
