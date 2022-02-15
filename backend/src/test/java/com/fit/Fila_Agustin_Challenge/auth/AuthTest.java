package com.fit.Fila_Agustin_Challenge.auth;

import com.fit.Fila_Agustin_Challenge.ApiApplication;
import com.fit.Fila_Agustin_Challenge.entities.Usuario;
import com.fit.Fila_Agustin_Challenge.exceptions.CrearCuentaException;
import com.fit.Fila_Agustin_Challenge.models.CrearCuentaRequestModel;
import com.fit.Fila_Agustin_Challenge.services.AuthService;
import com.fit.Fila_Agustin_Challenge.services.JWTService;
import com.fit.Fila_Agustin_Challenge.services.UsuarioService;
import org.junit.Assert;
import org.junit.Before;
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
    @Autowired
    private UsuarioService usuarioService;

    public CrearCuentaRequestModel nombreDeUsuarioTest;
    public CrearCuentaRequestModel mailTest;

    @Before
    public void generarUsuarios(){
        nombreDeUsuarioTest =
                new CrearCuentaRequestModel("Agustin", "Fila", "nombreDeUsuarioTest@gmail.com", "nombreDeUsuarioTest", "nombreDeUsuarioTest");
        if(!usuarioService.buscarPorNombreDeUsuario("nombreDeUsuarioTest").isPresent()){
            authService.crearCuenta(nombreDeUsuarioTest);
        }
        mailTest =
                new CrearCuentaRequestModel("Agustin", "Fila", "mailTest@gmail.com", "mailTest", "mailTest");
        if(!usuarioService.buscarPorNombreDeUsuario("mailTest").isPresent()){
            authService.crearCuenta(mailTest);
        }
    }

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
                new CrearCuentaRequestModel("Agustin", "Fila", "mailInvalido", "mailInvalido", "mailInvalido");
        Exception exception = Assertions.assertThrows(CrearCuentaException.class, () -> {
            authService.crearCuenta(crearCuentaRequestModel);
        });
        Assert.assertEquals("El mail es invalido", exception.getMessage());
    }
    @Test
    @DisplayName("Nombre de usuario existente")
    public void nombreDeUsuarioExistente(){
        Exception exception = Assertions.assertThrows(CrearCuentaException.class, () -> {
            authService.crearCuenta(nombreDeUsuarioTest);
        });
        Assert.assertEquals("Nombre de usuario ya en uso", exception.getMessage());
    }
    @Test
    @DisplayName("Mail existente")
    public void mailExistente(){
        mailTest.setNombreUsuario("cualquierCosa");
        Exception exception = Assertions.assertThrows(CrearCuentaException.class, () -> {
            authService.crearCuenta(mailTest);
        });
        Assert.assertEquals("Mail ya en uso", exception.getMessage());
    }
}
