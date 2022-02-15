package com.fit.Fila_Agustin_Challenge.services;

import com.fit.Fila_Agustin_Challenge.entities.Compra;
import com.fit.Fila_Agustin_Challenge.entities.Usuario;
import com.fit.Fila_Agustin_Challenge.models.CalcularPrecio;
import com.fit.Fila_Agustin_Challenge.models.NuevaCompra;
import com.fit.Fila_Agustin_Challenge.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Compra comprar(NuevaCompra nuevaCompra){
        Compra compra       = new Compra();
        compra.setAssetId(nuevaCompra.getAsset_id());
        compra.setExchangeId(nuevaCompra.getExchange_id());
        compra.setFecha(new Date());
        compra.setCostoTotal(nuevaCompra.getCantidadDolar());
        compra.setCantidad(nuevaCompra.getCantidad());
        compra.setUsuario(usuarioService.buscarPorId(nuevaCompra.getIdUsuario()).get());
        compra.setComisionTotal(nuevaCompra.getComision() * nuevaCompra.getCantidadDolar());
        compra.setValorUnitarioUSD(nuevaCompra.getValorUnitarioUSD());
        compra = compraRepository.save(compra);
        return compra;
    }

    public List<Compra> buscarPorUsuario(String idUsuario){
        List<Compra> comprasUsuario = compraRepository.buscarPorUsuario(idUsuario);
        return comprasUsuario;
    }

    public Double calcularPrecioUSD(CalcularPrecio calcularPrecio){
        return (calcularPrecio.getCantidad() * calcularPrecio.getValorUnitarioUSD()) * (1 + calcularPrecio.getComision());
    }
}
