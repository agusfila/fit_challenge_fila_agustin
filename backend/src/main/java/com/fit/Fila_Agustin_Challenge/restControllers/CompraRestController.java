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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compras")
public class CompraRestController {
    @Autowired
    private CompraService compraService;

    @PostMapping("/comprar")
    public ResponseEntity<Object> comprar(@RequestBody()NuevaCompra nuevaCompra){
        JSONObject respuesta    = new JSONObject();
        Gson gson               = new Gson();
        try {
            Compra compra = compraService.comprar(nuevaCompra);
            return new ResponseEntity<>(compra, HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/calcularPrecioUSD")
    public ResponseEntity<Double> calcularPrecio(@RequestBody CalcularPrecio calcularPrecio){
        Double precioTotal = compraService.calcularPrecioUSD(calcularPrecio);
        return new ResponseEntity<Double>(precioTotal, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("idUsuario")String idUsuario){
        Gson gson = new Gson();
        try{
            List<Compra> compras = compraService.buscarPorUsuario(idUsuario);
            return new ResponseEntity<Object>(gson.toJson(compras), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
