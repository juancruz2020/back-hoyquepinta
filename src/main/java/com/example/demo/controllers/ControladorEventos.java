package com.example.demo.controllers;

import com.example.demo.dto.ResenaDTO;
import com.example.demo.dto.ResenaResponseDTO;
import com.example.demo.dto.eventoDBO;
import com.example.demo.service.EventosService;
import com.example.demo.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class ControladorEventos {

    @Autowired
    EventosService eventosService;

    @PostMapping("/crear")
    public ResponseEntity<?> Crear(eventoDBO dto) {
        boolean flag = eventosService.crearEvento(dto);
        if (flag) {
            return ResponseEntity.ok("creado");
        }
        else  {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/crearResena")
    public ResponseEntity<?> crearResena(ResenaDTO dto) {
        boolean flag = eventosService.crearresena(dto);
        if (flag) {
            return ResponseEntity.ok("creado");
        }
        else  {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/resenas")
    public List<ResenaResponseDTO> getResenas(int idEvento) {
        return eventosService.obtenerResenasPorEvento(idEvento);
    }

    @GetMapping("/resenasPromedio")
    public Double promedioResenas(int idEvento) {
        return eventosService.obtenerPromedioEstrellasPorEvento(idEvento);
    }
}
