package com.example.demo.repository;

import com.example.demo.model.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResenaRepository extends JpaRepository<Resena, Integer> {
    List<Resena> findByEvento_IdEvento(Integer idEvento);

    @Query("SELECT AVG(r.estrellas) FROM Resena r WHERE r.evento.idEvento = :idEvento")
    Double promedioEstrellasPorEvento(Integer idEvento);
}
