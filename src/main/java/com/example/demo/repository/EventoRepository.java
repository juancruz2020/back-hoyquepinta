package com.example.demo.repository;

import com.example.demo.model.Evento;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
public interface EventoRepository extends CrudRepository<Evento,Integer> {
    List<Evento> findByPatrocinado_IdPatrocinado(Integer idPatrocinado);
    List<Evento> findByFecha(LocalDate fecha);
    List<Evento> findByPatrocinado_IdPatrocinadoAndUbicacion_IdUbicacionAndCategoria_IdCategoria(
            Integer idPatrocinado,
            Integer idUbicacion,
            Integer idCategoria
    );
    List<Evento> findByUsuario_IdUsuario(Integer idUsuario);
}
