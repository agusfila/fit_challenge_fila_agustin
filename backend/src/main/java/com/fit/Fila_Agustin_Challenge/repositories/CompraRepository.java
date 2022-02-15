package com.fit.Fila_Agustin_Challenge.repositories;

import com.fit.Fila_Agustin_Challenge.entities.Compra;
import com.fit.Fila_Agustin_Challenge.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import retrofit2.http.Path;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompraRepository extends JpaRepository<Compra, String> {
    @Query("SELECT c FROM Compra c WHERE c.usuario.id = :idUsuario")
    List<Compra> buscarPorUsuario(@Path("usuario")String idUsuario);
}
