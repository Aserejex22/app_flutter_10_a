package com.utez.backend.controller;

import com.utez.backend.controller.dto.RegistroDto;
import com.utez.backend.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody RegistroDto registroDto) {
        try {
            usuarioService.registrarUsuario(registroDto);
            return new ResponseEntity<>(Collections.singletonMap("message", "Usuario registrado exitosamente"), HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(Collections.singletonMap("error", e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.singletonMap("error", "Ocurrió un error inesperado"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}