package com.example.demo.controllers;

import com.example.demo.service.PublicacionesMiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/PublicacionesMias")
@CrossOrigin(origins = "http://localhost:5173")
public class ControladorPublicacionesMias {

    @Autowired
    PublicacionesMiasService publicacionesMiasService;

    @GetMapping("/publicaciones")
    public ResponseEntity<?> obtenerEventosMios(int id_usuario){
        return ResponseEntity.ok(publicacionesMiasService.obtenerEventosPublicadosPorUsuario(id_usuario));
    }
}
