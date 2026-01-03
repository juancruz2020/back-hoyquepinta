package com.example.demo.controllers;


import com.example.demo.dto.ModificarUsuarioDTO;
import com.example.demo.dto.RegistroUsuarioDTO;
import com.example.demo.dto.loginUsuarioDTO;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class ControladorUsuario {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/registroUsuario")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegistroUsuarioDTO dto) {


        boolean flag = usuarioService.registroUsuario(dto);
        if (flag) {
            return ResponseEntity.ok("registrado");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/registroOrganizacion")
    public ResponseEntity<?> registroOrganizacion(@RequestBody RegistroUsuarioDTO dto) {


        boolean flag = usuarioService.registroOrg(dto);
        if (flag) {
            return ResponseEntity.ok("registrado");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/loginUsuario")
    public ResponseEntity<?> loginUsuario(@RequestBody loginUsuarioDTO dto) {

        Usuario flag = usuarioService.loginUsuario(dto);
        if (flag != null) {
            return ResponseEntity.ok(flag);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/loginOrganizacion")
    public ResponseEntity<?> loginOrganizacion(@RequestBody loginUsuarioDTO dto) {

        Usuario flag = usuarioService.loginOrganizacion(dto);
        if (flag != null) {
            return ResponseEntity.ok(flag);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/modificarUsuario")
    public ResponseEntity<?> modificarUsuario(@RequestBody ModificarUsuarioDTO dto) {

        boolean flag = usuarioService.modificarUsuario(dto);
        if (flag) {
            return ResponseEntity.ok("modificado");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}