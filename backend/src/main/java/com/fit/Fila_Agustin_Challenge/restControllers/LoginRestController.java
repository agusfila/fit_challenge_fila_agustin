package com.fit.Fila_Agustin_Challenge.restControllers;

import com.fit.Fila_Agustin_Challenge.entities.Usuario;
import com.fit.Fila_Agustin_Challenge.services.JWTService;
import com.fit.Fila_Agustin_Challenge.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginRestController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("usuario")String nombreUsuario, @RequestParam("clave")String clave){
        try {
            String token = usuarioService.login(nombreUsuario, clave);
            return new ResponseEntity<String>(token, HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/crear_cuenta")
    public ResponseEntity<String> crearCuenta(@RequestParam("usuario")String nombreUsuario, @RequestParam("clave")String clave){
        try{
            Usuario usuario = usuarioService.crearCuenta(nombreUsuario, clave);
            return new ResponseEntity<String>(usuario.getId().toString(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
