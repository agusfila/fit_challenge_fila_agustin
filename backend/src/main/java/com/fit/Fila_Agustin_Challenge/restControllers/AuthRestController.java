package com.fit.Fila_Agustin_Challenge.restControllers;

import com.fit.Fila_Agustin_Challenge.entities.Usuario;
import com.fit.Fila_Agustin_Challenge.models.CrearCuentaRequestModel;
import com.fit.Fila_Agustin_Challenge.models.InicioSesionRequestModel;
import com.fit.Fila_Agustin_Challenge.services.AuthService;
import com.fit.Fila_Agustin_Challenge.services.JWTService;
import com.fit.Fila_Agustin_Challenge.services.UsuarioService;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    @Autowired
    private AuthService authService;

    @PostMapping(path="/login", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, Object>> login(@RequestBody() InicioSesionRequestModel inicioSesion){
        HashMap<String, Object> json = new HashMap<>();
        try {
            Usuario usuario = authService.login(inicioSesion);
            String token    = authService.crearToken(usuario.getNombreUsuario());
            json.put("token", token);
            json.put("idUsuario", usuario.getId());
            return new ResponseEntity<HashMap<String, Object>>(json, HttpStatus.ACCEPTED);
        } catch (Exception e){
            json.put("mensaje", e.getMessage());
            return new ResponseEntity<HashMap<String, Object>>(json, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/crear_cuenta")
    public ResponseEntity<HashMap<String, Object>> crearCuenta(@RequestBody() CrearCuentaRequestModel crearCuenta){
        HashMap<String, Object> json = new HashMap<>();
        try{
            authService.crearCuenta(crearCuenta);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            json.put("mensaje", e.getMessage());
            return new ResponseEntity<HashMap<String, Object>>(json, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/validar_token")
    public ResponseEntity<Object> validarToken(@RequestBody() String token){
        try {
            authService.validarToken(token);
            return new ResponseEntity<Object>(true, HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<Object>(false, HttpStatus.ACCEPTED);
        }
    }
}
