package com.example.demo.controllers;

import com.example.demo.service.FavoritoService;
import com.example.demo.service.HoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hoy")
@CrossOrigin(origins = "http://localhost:5173")
public class ControladorHoy {

    @Autowired
    private HoyService hoyService;

    @GetMapping("/hoy")
    public ResponseEntity<?> obtenerPatrocinados() {
        return ResponseEntity.ok(hoyService.obtenerEventosDeHoy());
    }
}
