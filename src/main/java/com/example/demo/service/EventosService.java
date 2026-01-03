package com.example.demo.service;

import com.example.demo.dto.BusquedaDTO;
import com.example.demo.dto.eventoDBO;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class EventosService {
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private UbicacionRepository ubicacionRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PatrocinadoRepository patrocinadoRepository;

    public List<Evento> obtenerEventosPatrocinados() {
        return eventoRepository.findByPatrocinado_IdPatrocinado(1);
    }

    public List<Evento> obtenerEventosFiltrados(BusquedaDTO dto) {
        return eventoRepository.findByPatrocinado_IdPatrocinadoAndUbicacion_IdUbicacionAndCategoria_IdCategoria(dto.getId_patrocinado(), dto.getId_ubicacion(), dto.getId_categoria());
    }


    public boolean crearEvento(eventoDBO dto) {

        // 1) Validar y parsear fecha (YYYY-MM-DD)
        LocalDate fecha;
        try {
            fecha = LocalDate.parse(dto.getFecha());
        } catch (DateTimeParseException e) {
            System.out.println("Fecha inválida. Formato esperado: YYYY-MM-DD");
            return false;
        }

        // 2) Buscar Ubicación
        Optional<Ubicacion> ubicacionOpt =
                ubicacionRepository.findById(dto.getId_ubicacion());
        if (ubicacionOpt.isEmpty()) {
            System.out.println("Ubicación no encontrada");
            return false;
        }

        // 3) Buscar Categoría
        Optional<Categoria> categoriaOpt =
                categoriaRepository.findById(dto.getId_categoria());
        if (categoriaOpt.isEmpty()) {
            System.out.println("Categoría no encontrada");
            return false;
        }

        // 4) Buscar Usuario
        Optional<Usuario> usuarioOpt =
                usuarioRepository.findById(dto.getId_usuario());
        if (usuarioOpt.isEmpty()) {
            System.out.println("Usuario no encontrado");
            return false;
        }

        // 5) Buscar Patrocinado por defecto (ID = 2)
        Optional<Patrocinado> patrocinadoOpt =
                patrocinadoRepository.findById(2);
        if (patrocinadoOpt.isEmpty()) {
            System.out.println("Patrocinado por defecto no encontrado");
            return false;
        }

        // 6) Crear Evento
        Evento evento = new Evento();
        evento.setTitulo(dto.getTitulo());
        evento.setDescripcion(dto.getDescripcion());
        evento.setFecha(fecha);
        evento.setFoto1(dto.getFoto1());
        evento.setFoto2(dto.getFoto2());

        evento.setUbicacion(ubicacionOpt.get());
        evento.setCategoria(categoriaOpt.get());
        evento.setUsuario(usuarioOpt.get());
        evento.setPatrocinado(patrocinadoOpt.get());

        // 7) Guardar
        eventoRepository.save(evento);
        return true;
    }
}

