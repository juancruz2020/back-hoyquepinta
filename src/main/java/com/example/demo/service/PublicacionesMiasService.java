package com.example.demo.service;

import com.example.demo.model.Evento;
import com.example.demo.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PublicacionesMiasService {
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> obtenerEventosPublicadosPorUsuario(Integer idUsuario) {
        return eventoRepository.findByUsuario_IdUsuario(idUsuario);
    }
}
