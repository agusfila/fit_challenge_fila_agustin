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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody() InicioSesionRequestModel inicioSesion){
        JSONObject respuesta    = new JSONObject();
        String token            = "";
        String idUsuario        = "";
        String mensaje          = "";
        try {
            Usuario usuario = authService.login(inicioSesion);
            token           = authService.crearToken(usuario.getNombreUsuario());
            idUsuario       = usuario.getId();
        } catch (Exception e){
            respuesta.put("error", true);
            mensaje = e.getMessage();
        }
        respuesta.put("mensaje", mensaje);
        respuesta.put("token", token);
        respuesta.put("idUsuario", idUsuario);
        return new ResponseEntity<String>(respuesta.toString(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/crear_cuenta")
    public ResponseEntity<String> crearCuenta(@RequestBody() CrearCuentaRequestModel crearCuenta){
        JSONObject respuesta = new JSONObject();
        try{
            Usuario usuario = authService.crearCuenta(crearCuenta);
            respuesta.put("error", false);
            respuesta.put("mensaje", "");
        } catch (Exception e) {
            respuesta.put("error", true);
            respuesta.put("mensaje", e.getMessage());
        }
        return new ResponseEntity<String>(respuesta.toString(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/validar_token")
    public ResponseEntity<Boolean> validarToken(@RequestBody() String token){
        return new ResponseEntity<Boolean>((Boolean) !token.equals("vacio") && authService.validarToken(token), HttpStatus.ACCEPTED);
    }
}
