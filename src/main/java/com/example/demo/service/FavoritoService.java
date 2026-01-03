package com.example.demo.service;

import com.example.demo.model.Favorito;
import com.example.demo.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoService {
    @Autowired
    private FavoritoRepository favoritoRepository;

    public List<Favorito> obtenerFavoritosPorUsuario(Integer idUsuario) {
        return favoritoRepository.findByUsuario_IdUsuario(idUsuario);
    }
}
