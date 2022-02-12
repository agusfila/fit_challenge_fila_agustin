package com.fit.Fila_Agustin_Challenge.services;

import com.fit.Fila_Agustin_Challenge.entities.Usuario;
import com.fit.Fila_Agustin_Challenge.exceptions.CredencialesIncorrectas;
import com.fit.Fila_Agustin_Challenge.exceptions.NombreDeUsuarioExistente;
import com.fit.Fila_Agustin_Challenge.exceptions.UsuarioInexistente;
import com.fit.Fila_Agustin_Challenge.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public String login(String nombreUsuario, String clave){
        Optional<Usuario> opUsuario = usuarioRepository.buscarPorCredenciales(nombreUsuario, clave);
        if(!opUsuario.isPresent()) throw new CredencialesIncorrectas("Error: Las credenciales son incorrectas");
        String token = "";
        return token;
    }

    public Usuario crearCuenta(String nombreUsuario, String clave){
        Optional<Usuario> opUsuario = usuarioRepository.buscarPorNombreDeUsuario(nombreUsuario);
        if(opUsuario.isPresent()) throw new NombreDeUsuarioExistente("Error: Nombre de usuario ya en uso");
        Usuario usuario = new Usuario(nombreUsuario, clave);
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(String idUsuario){
        Optional<Usuario> opUsuario = usuarioRepository.findById(idUsuario);
        if(!opUsuario.isPresent()) throw new UsuarioInexistente("Error: El usuario no existe");
        return opUsuario.get();
    }
}
