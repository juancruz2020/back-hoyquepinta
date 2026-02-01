package com.example.demo.service;

import com.example.demo.dto.BusquedaDTO;
import com.example.demo.dto.ResenaDTO;
import com.example.demo.dto.ResenaResponseDTO;
import com.example.demo.dto.eventoDBO;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
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
    @Autowired
    private ResenaRepository resenaRepository;

    public List<Evento> obtenerEventosPatrocinados() {
        return eventoRepository.findByPatrocinado_IdPatrocinado(1);
    }

    public List<Evento> obtenerEventosFiltrados(BusquedaDTO dto) {
        return eventoRepository.findByPatrocinado_IdPatrocinadoOrUbicacion_IdUbicacionOrCategoria_IdCategoria(dto.getId_patrocinado(), dto.getId_ubicacion(), dto.getId_categoria());
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


    public boolean crearresena(ResenaDTO dto) {
        try {
            Evento evento = eventoRepository.findById(dto.getIdEvento())
                    .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

            Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            Resena resena = new Resena();
            resena.setEstrellas(dto.getEstrellas());
            resena.setDescripcion(dto.getDescripcion());
            resena.setEvento(evento);
            resena.setUsuario(usuario);
            resenaRepository.save(resena);
            return true;
        } catch (RuntimeException e) {
            System.out.println("Resena no publicada");
            return false;
        }
    }

    public List<ResenaResponseDTO> obtenerResenasPorEvento(Integer idEvento) {

        List<Resena> resenas = resenaRepository.findByEvento_IdEvento(idEvento);
        List<ResenaResponseDTO> respuesta = new ArrayList<>();

        for (Resena r : resenas) {
            ResenaResponseDTO dto = new ResenaResponseDTO();

            dto.setIdResena(r.getIdResena());
            dto.setEstrellas(r.getEstrellas());
            dto.setDescripcion(r.getDescripcion());
            dto.setIdEvento(idEvento);

            if (r.getUsuario() != null) {
                dto.setNombreUsuario(r.getUsuario().getNombre());
            }

            respuesta.add(dto);
        }

        return respuesta;
    }

    public Double obtenerPromedioEstrellasPorEvento(Integer idEvento) {

        Double promedio = resenaRepository.promedioEstrellasPorEvento(idEvento);

        // Si no hay reseñas, evitamos null
        return promedio != null ? promedio : 0.0;
    }
}

