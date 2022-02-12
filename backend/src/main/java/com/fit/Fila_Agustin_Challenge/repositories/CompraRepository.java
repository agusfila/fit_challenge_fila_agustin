package com.fit.Fila_Agustin_Challenge.repositories;

import com.fit.Fila_Agustin_Challenge.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, String> {
}
