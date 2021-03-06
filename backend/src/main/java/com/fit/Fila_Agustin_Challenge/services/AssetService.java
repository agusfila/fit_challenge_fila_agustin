package com.fit.Fila_Agustin_Challenge.services;

import com.fit.Fila_Agustin_Challenge.coinapi.*;
import com.fit.Fila_Agustin_Challenge.models.AssetModel;
import com.fit.Fila_Agustin_Challenge.models.ExchangeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AssetService {
    public List<AssetModel> listarAssets(String iconSize) throws IOException {
        List<Asset> assets              =  CoinApiSvc.instancia().listarAssets();
        List<AssetIcon> assetsIcons     =  CoinApiSvc.instancia().listarIconosAssets(iconSize);
        Collections.sort(assets, Comparator.comparingDouble(o1 -> o1.getVolume_1mth_usd()));
        Collections.reverse(assets);
        List<Asset> finalAssets         = assets.subList(0, 5);
        List<AssetModel> top5Assets     = new ArrayList<AssetModel>();
        finalAssets.forEach(unAsset -> {
            try {
                ExchangeRate exchangeRate = CoinApiSvc.instancia().buscarAssetExchangeRate(unAsset.getAsset_id(), "USD");
                List<AssetIcon> assetIcon =  assetsIcons.stream().filter(unIcono ->
                        unIcono.getAsset_id().equals(unAsset.getAsset_id())).collect(Collectors.toList());
                top5Assets.add( new AssetModel(
                    unAsset.getAsset_id(),
                    unAsset.getName(),
                    unAsset.getPrice_usd(),
                    exchangeRate.getRate(),
                    assetIcon.size() > 0 ? assetIcon.get(0).getUrl() : ""));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return top5Assets;
    }
}
