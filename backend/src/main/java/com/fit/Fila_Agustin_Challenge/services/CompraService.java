package com.fit.Fila_Agustin_Challenge.services;

import com.fit.Fila_Agustin_Challenge.entities.Compra;
import com.fit.Fila_Agustin_Challenge.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Compra comprar(String idUsuario, String idAsset, String idExchange, Double cantidadDolar, Double comisionExchange, Double rate){
        Compra compra       = new Compra();
        try {
            Double cantidadAsset = (cantidadDolar * (1 - comisionExchange)) / rate;
            Double comisionTotal = cantidadDolar * comisionExchange;
            compra.setAssetId(idAsset);
            compra.setExchangeId(idExchange);
            compra.setFecha(new Date());
            compra.setCostoTotal(cantidadDolar);
            compra.setCantidad(cantidadAsset);
            compra.setUsuario(usuarioService.buscarPorId(idUsuario));
            compra.setComisionTotal(comisionTotal);
            compra.setValorUnitarioUSD(rate);
            compra = compraRepository.save(compra);
            return compra;
        } catch (Exception e){
            return null;
        }
    }
}
