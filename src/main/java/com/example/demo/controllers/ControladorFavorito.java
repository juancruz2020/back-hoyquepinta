package com.example.demo.controllers;

import com.example.demo.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/favorito")
@CrossOrigin(origins = "http://localhost:5173")
public class ControladorFavorito {

    @Autowired
    private FavoritoService favoritoService;

    @GetMapping("/favorito")
    public ResponseEntity<?> obtenerPatrocinados(int idUsuario) {
        return ResponseEntity.ok(favoritoService.obtenerFavoritosPorUsuario(idUsuario));
    }

}
