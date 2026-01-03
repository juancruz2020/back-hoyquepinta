package com.example.demo.service;

import com.example.demo.model.Ubicacion;
import com.example.demo.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionService {
    @Autowired
    private UbicacionRepository ubicacionRepository;

    public List<Ubicacion> obtenerTodas() {
        return ubicacionRepository.findAll();
    }
}
