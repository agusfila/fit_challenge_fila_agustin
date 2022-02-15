package com.fit.Fila_Agustin_Challenge.services;

import com.fit.Fila_Agustin_Challenge.entities.Usuario;
import com.fit.Fila_Agustin_Challenge.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> buscarPorCredenciales(String nombreUsuario, String clave){
        return usuarioRepository.buscarPorCredenciales(nombreUsuario, clave);
    }
    public Optional<Usuario> buscarPorNombreDeUsuario(String nombreUsuario){
        return usuarioRepository.buscarPorNombreDeUsuario(nombreUsuario);
    }
    public Optional<Usuario> buscarPorMail(String mail){
        return usuarioRepository.buscarPorMail(mail);
    }

    public Optional<Usuario> buscarPorId(String idUsuario){
        Optional<Usuario> opUsuario = usuarioRepository.findById(idUsuario);
        return opUsuario;
    }

    public Usuario insert(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
