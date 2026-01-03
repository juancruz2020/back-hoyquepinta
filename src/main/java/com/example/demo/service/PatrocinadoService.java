package com.example.demo.service;

import com.example.demo.model.Patrocinado;
import com.example.demo.repository.PatrocinadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrocinadoService {
    @Autowired
    private PatrocinadoRepository patrocinadoRepository;

    public List<Patrocinado> obtenerTodos() {
        return patrocinadoRepository.findAll();
    }
}
