package com.example.demo.controllers;

import com.example.demo.dto.BusquedaDTO;
import com.example.demo.repository.PatrocinadoRepository;
import com.example.demo.repository.UbicacionRepository;
import com.example.demo.service.EventosService;
import com.example.demo.service.PatrocinadoService;
import com.example.demo.service.UbicacionService;
import com.example.demo.service.categoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/busqueda")
public class ControladorBusqueda {

    @Autowired categoriaService categoriaService;
    @Autowired UbicacionService ubicacionService;
    @Autowired PatrocinadoService patrocinadoService;
    @Autowired EventosService eventosService;

    @GetMapping("/patrocinados")
    public ResponseEntity<?> obtenerPatrocinados() {
        return ResponseEntity.ok(patrocinadoService.obtenerTodos());
    }

    @GetMapping("/categorias")
    public ResponseEntity<?> obtenerCategorias() {
        return ResponseEntity.ok(categoriaService.obtenerTodas());
    }

    @GetMapping("/ubicaciones")
    public ResponseEntity<?> obtenerUbicaciones() {
        return ResponseEntity.ok(ubicacionService.obtenerTodas());
    }

    @PostMapping("/filtrado")
    public ResponseEntity<?> obtenerEventos(BusquedaDTO dto){
        return ResponseEntity.ok(eventosService.obtenerEventosFiltrados(dto));
    }
}
