package com.fit.Fila_Agustin_Challenge.restControllers;

import com.fit.Fila_Agustin_Challenge.exceptions.CoinApiSvcException;
import com.fit.Fila_Agustin_Challenge.models.ExchangeModel;
import com.fit.Fila_Agustin_Challenge.services.ExchangeService;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/exchanges")
public class ExchangeRestController {
    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/listar")
    public ResponseEntity<Object> top3Exchanges(@RequestParam(required = false) Optional<String> iconSize) throws IOException {
        HashMap<String, String> response    = new HashMap<>();
        Gson gson                           = new Gson();
        try {
            List<ExchangeModel> exchanges = exchangeService.top3Exchanges(iconSize.isPresent() ? iconSize.get() : "512");
            return new ResponseEntity<Object>(gson.toJson(exchanges), HttpStatus.ACCEPTED);
        } catch (Exception e){
            response.put("mensaje", e.getMessage());
            return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
