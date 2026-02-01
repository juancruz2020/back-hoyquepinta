package com.example.demo.controllers;

import com.example.demo.dto.RegistroUsuarioDTO;
import com.example.demo.service.EventosService;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.categoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inicio")
@CrossOrigin(origins = "http://localhost:5173")
public class ControladorInicio {


    @Autowired categoriaService categoriaService;
    @Autowired EventosService eventosService;

    @GetMapping("/categorias")
    public ResponseEntity<?> obtenerCategorias() {
        return ResponseEntity.ok(categoriaService.obtenerTodas());
    }
    @GetMapping("/patrocinados")
    public ResponseEntity<?> obtenerPatrocinados() {
        return ResponseEntity.ok(eventosService.obtenerEventosPatrocinados());
    }

}
