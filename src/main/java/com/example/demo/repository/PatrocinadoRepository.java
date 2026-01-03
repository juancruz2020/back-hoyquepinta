package com.example.demo.repository;

import com.example.demo.model.Patrocinado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PatrocinadoRepository extends JpaRepository<Patrocinado, Integer> {
}
