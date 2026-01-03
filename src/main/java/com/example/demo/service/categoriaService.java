package com.example.demo.service;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class categoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }
}
