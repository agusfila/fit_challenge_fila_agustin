package com.fit.Fila_Agustin_Challenge.auth;

import com.fit.Fila_Agustin_Challenge.ApiApplication;
import com.fit.Fila_Agustin_Challenge.exceptions.CrearCuentaException;
import com.fit.Fila_Agustin_Challenge.models.CrearCuentaRequestModel;
import com.fit.Fila_Agustin_Challenge.services.AuthService;
import com.fit.Fila_Agustin_Challenge.services.JWTService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= ApiApplication.class)
public class AuthTest {
    @Autowired
    private AuthService authService;
    @Autowired
    private JWTService jwtService;

    @Test
    @DisplayName("Generacion de Token")
    public void generarToken(){
        String nombreDeUsuario      = "agustin";
        String token                = authService.crearToken(nombreDeUsuario);
        Assert.assertEquals(nombreDeUsuario, jwtService.nombreDeUsuarioToken(token));
    }
    @Test
    @DisplayName("Validacion de mail")
    public void validacionMail(){
        CrearCuentaRequestModel crearCuentaRequestModel =
                new CrearCuentaRequestModel("Agustin", "Fila", "agusfila", "agustin", "agustin123");
        Exception exception = Assertions.assertThrows(CrearCuentaException.class, () -> {
            authService.crearCuenta(crearCuentaRequestModel);
        });
        Assert.assertEquals("El mail es invalido", exception.getMessage());
    }
}
