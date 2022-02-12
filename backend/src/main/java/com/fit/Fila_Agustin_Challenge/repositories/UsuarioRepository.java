package com.fit.Fila_Agustin_Challenge.repositories;

import com.fit.Fila_Agustin_Challenge.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import retrofit2.http.Path;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    @Query("SELECT a FROM Usuario a WHERE a.usuario = :nombreDeUsuario")
    Optional<Usuario> buscarPorNombreDeUsuario(@Path("nombreDeUsuario")String nombreDeUsuario);

    @Query("SELECT a FROM Usuario a WHERE a.usuario = :nombreDeUsuario AND a.clave = :clave")
    Optional<Usuario> buscarPorCredenciales(@Path("nombreDeUsuario")String nombreDeUsuario, @Path("nombreDeUsuario")String clave);

}
