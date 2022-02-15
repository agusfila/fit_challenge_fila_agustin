package com.fit.Fila_Agustin_Challenge.compra;

import com.fit.Fila_Agustin_Challenge.ApiApplication;
import com.fit.Fila_Agustin_Challenge.entities.Compra;
import com.fit.Fila_Agustin_Challenge.models.CalcularPrecio;
import com.fit.Fila_Agustin_Challenge.models.NuevaCompra;
import com.fit.Fila_Agustin_Challenge.services.CompraService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= ApiApplication.class)
public class CompraTest {
    @Autowired
    private CompraService compraService;

    @Test
    @DisplayName("Calcular precio total")
    public void calcularPrecio(){
        CalcularPrecio calcularPrecio = new CalcularPrecio(2.0, 5.0, 0.25);
        Assert.assertEquals(java.util.Optional.of(12.5).get(), compraService.calcularPrecioUSD(calcularPrecio));
    }
}
