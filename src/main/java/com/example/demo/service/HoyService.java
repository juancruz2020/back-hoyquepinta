package com.example.demo.service;

import com.example.demo.model.Evento;
import com.example.demo.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;

@Service
public class HoyService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> obtenerEventosDeHoy() {
        LocalDate hoy = LocalDate.now();
        return eventoRepository.findByFecha(hoy);
    }
}

