package com.fit.Fila_Agustin_Challenge.restControllers;

import com.fit.Fila_Agustin_Challenge.coinapi.Asset;
import com.fit.Fila_Agustin_Challenge.coinapi.AssetIcon;
import com.fit.Fila_Agustin_Challenge.coinapi.Exchange;
import com.fit.Fila_Agustin_Challenge.exceptions.CoinApiSvcException;
import com.fit.Fila_Agustin_Challenge.models.AssetModel;
import com.fit.Fila_Agustin_Challenge.models.ExchangeModel;
import com.fit.Fila_Agustin_Challenge.services.AssetService;
import com.fit.Fila_Agustin_Challenge.services.ExchangeService;
import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/assets")
public class AssetRestController {
    @Autowired
    private AssetService assetService;

    @GetMapping("/listar")
    public ResponseEntity<Object> listarAssets(@RequestParam(required = false) Optional<String> iconSize){
        Map<String, String> response    = new HashMap<>();
        Gson gson                       = new Gson();
        JSONObject json                 = new JSONObject();
        try {
            List<AssetModel> assets = assetService.listarAssets(iconSize.isPresent() ? iconSize.get() : "512");
            return new ResponseEntity(gson.toJson(assets), HttpStatus.ACCEPTED);
        } catch (Exception e){
            json.put("mensaje", "Error: " + e.getMessage());
            return new ResponseEntity(json.toString(), HttpStatus.BAD_REQUEST);
        }
    }

}
