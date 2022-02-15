package com.fit.Fila_Agustin_Challenge.restControllers;

import com.fit.Fila_Agustin_Challenge.entities.Compra;
import com.fit.Fila_Agustin_Challenge.entities.Usuario;
import com.fit.Fila_Agustin_Challenge.exceptions.CoinApiSvcException;
import com.fit.Fila_Agustin_Challenge.models.CalcularPrecio;
import com.fit.Fila_Agustin_Challenge.models.CompraPostModel;
import com.fit.Fila_Agustin_Challenge.models.NuevaCompra;
import com.fit.Fila_Agustin_Challenge.services.CompraService;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compras")
public class CompraRestController {
    @Autowired
    private CompraService compraService;

    @PostMapping("/comprar")
    public ResponseEntity<HashMap<String, Object>> comprar(@RequestBody()NuevaCompra nuevaCompra){
        HashMap<String, Object> response = new HashMap<>();
        try {
            compraService.comprar(nuevaCompra);
            response.put("mensaje", "Compra realizada con exito!");
            return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.CREATED);
        } catch (Exception e){
            response.put("mensaje", e.getMessage());
            return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/calcularPrecioUSD")
    public ResponseEntity<HashMap<String, Object>> calcularPrecio(@RequestBody CalcularPrecio calcularPrecio){
        HashMap<String, Object> response = new HashMap<>();
        try {
            Double precioTotal = compraService.calcularPrecioUSD(calcularPrecio);
            response.put("precioTotal", precioTotal);
            return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
