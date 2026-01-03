package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByMailAndTipoUsuario_IdTipo(String mail, Integer idTipo);
    Optional<Usuario> findByMailAndTipoUsuario_IdTipo(String mail, Integer idTipo);


}