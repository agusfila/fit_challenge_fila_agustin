package com.fit.Fila_Agustin_Challenge.restControllers;

import com.fit.Fila_Agustin_Challenge.entities.Compra;
import com.fit.Fila_Agustin_Challenge.models.CompraPostModel;
import com.fit.Fila_Agustin_Challenge.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compra")
public class CompraRestController {
    @Autowired
    private CompraService compraService;

    @PostMapping("/comprar")
    public ResponseEntity<Object> comprar(@RequestParam("idUsuario") String idUsuario,
                                          @RequestParam("idAsset") String idAsset,
                                          @RequestParam("idExchange") String idExchange,
                                          @RequestParam("cantidadDolar") Double cantidadDolar,
                                          @RequestParam("comisionExchange") Double comisionExchange,
                                          @RequestParam("rate") Double rate){
        try {
            Compra compra = compraService.comprar(idUsuario, idAsset, idExchange, cantidadDolar, comisionExchange, rate);
            return new ResponseEntity<>(compra, HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
