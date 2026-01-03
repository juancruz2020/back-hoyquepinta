package com.example.demo.service;

import com.example.demo.dto.ModificarUsuarioDTO;
import com.example.demo.dto.RegistroUsuarioDTO;
import com.example.demo.dto.loginUsuarioDTO;
import com.example.demo.model.TipoUsuario;
import com.example.demo.model.Usuario;
import com.example.demo.repository.TipoUsuarioRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public boolean registroUsuario (RegistroUsuarioDTO dto) {
        Optional<TipoUsuario> tipoOpt = tipoUsuarioRepository.findById(2);
        if (usuarioRepository.existsByMailAndTipoUsuario_IdTipo(dto.getMail(), 2)) {
            System.out.println("Ya existe un usuario con ese mail y ese tipo");
            return false;
        }

        // 2) Crear entidad Usuario y setear campos
        Usuario usuario = new Usuario();
        usuario.setTipoUsuario(tipoOpt.get());
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setMail(dto.getMail());
        usuario.setContrasena(dto.getContrasena());
        usuario.setEdad(dto.getEdad());
        usuario.setDni(dto.getDni());

        // 3) Guardar
        usuarioRepository.save(usuario);
        return true;
    }

    public boolean registroOrg (RegistroUsuarioDTO dto) {
        Optional<TipoUsuario> tipoOpt = tipoUsuarioRepository.findById(1);
        if (usuarioRepository.existsByMailAndTipoUsuario_IdTipo(dto.getMail(), 1)) {
            System.out.println("Ya existe un usuario con ese mail y ese tipo");
            return false;
        }

        // 2) Crear entidad Usuario y setear campos
        Usuario usuario = new Usuario();
        usuario.setTipoUsuario(tipoOpt.get());
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setMail(dto.getMail());
        usuario.setContrasena(dto.getContrasena());
        usuario.setEdad(dto.getEdad());
        usuario.setDni(dto.getDni());

        // 3) Guardar
        usuarioRepository.save(usuario);
        return true;
    }

    public Usuario loginUsuario (loginUsuarioDTO dto) {

        Integer idTipo = 2;

        // 1) Verificar que exista el usuario con ese mail y tipo
        Optional<Usuario> usuarioOpt =
                usuarioRepository.findByMailAndTipoUsuario_IdTipo(dto.getMail(), idTipo);

        if (usuarioOpt.isEmpty()) {
            return null; // o lanzar excepción
        }

        Usuario usuario = usuarioOpt.get();

        // 2) Validar contraseña (simple, sin hash por ahora)
        if (!usuario.getContrasena().equals(dto.getContrasena())) {
            return null; // contraseña incorrecta
        }
        usuario.setContrasena(null);
        // 3) Login OK
        return usuario;
    }

    public Usuario loginOrganizacion (loginUsuarioDTO dto) {

        Integer idTipo = 1;

        // 1) Verificar que exista el usuario con ese mail y tipo
        Optional<Usuario> usuarioOpt =
                usuarioRepository.findByMailAndTipoUsuario_IdTipo(dto.getMail(), idTipo);

        if (usuarioOpt.isEmpty()) {
            return null; // o lanzar excepción
        }

        Usuario usuario = usuarioOpt.get();

        // 2) Validar contraseña (simple, sin hash por ahora)
        if (!usuario.getContrasena().equals(dto.getContrasena())) {
            return null; // contraseña incorrecta
        }
        usuario.setContrasena(null);
        // 3) Login OK
        return usuario;
    }




    public boolean modificarUsuario(ModificarUsuarioDTO dto) {

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(dto.getIdUsuario());
        if (usuarioOpt.isEmpty()) {
            return false;
        }

        Usuario usuarioBD = usuarioOpt.get();

        // Nombre
        if (dto.getNombre() != null && !dto.getNombre().trim().isEmpty()) {
            usuarioBD.setNombre(dto.getNombre());
        } else {
            usuarioBD.setNombre(usuarioBD.getNombre());
        }

        // Apellido
        if (dto.getApellido() != null && !dto.getApellido().trim().isEmpty()) {
            usuarioBD.setApellido(dto.getApellido());
        } else {
            usuarioBD.setApellido(usuarioBD.getApellido());
        }

        // Mail
        if (dto.getMail() != null && !dto.getMail().trim().isEmpty()) {
            usuarioBD.setMail(dto.getMail());
        } else {
            usuarioBD.setMail(usuarioBD.getMail());
        }

        // Edad (solo null aplica)
        if (dto.getEdad() != null) {
            usuarioBD.setEdad(dto.getEdad());
        } else {
            usuarioBD.setEdad(usuarioBD.getEdad());
        }

        usuarioRepository.save(usuarioBD);
        return true;
    }


    }


