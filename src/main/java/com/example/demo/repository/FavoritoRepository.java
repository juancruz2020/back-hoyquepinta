package com.example.demo.repository;

import com.example.demo.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface FavoritoRepository extends JpaRepository<Favorito,Integer> {
    List<Favorito> findByUsuario_IdUsuario(Integer idUsuario);
}
