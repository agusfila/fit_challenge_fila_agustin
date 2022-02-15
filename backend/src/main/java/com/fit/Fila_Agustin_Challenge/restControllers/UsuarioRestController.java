package com.fit.Fila_Agustin_Challenge.restControllers;

import com.fit.Fila_Agustin_Challenge.entities.Usuario;
import com.fit.Fila_Agustin_Challenge.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("idUsuario")String idUsuario){
        try {
            Optional<Usuario> opUsuario = usuarioService.buscarPorId(idUsuario);
            return new ResponseEntity<Object>(opUsuario.get(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
