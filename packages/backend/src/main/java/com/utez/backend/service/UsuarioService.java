package com.utez.backend.service;

import com.utez.backend.controller.dto.RegistroDto;
import com.utez.backend.model.Usuario;
import com.utez.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario registrarUsuario(RegistroDto registroDto) {
        // 1. Verificar si el email ya está en uso
        if (usuarioRepository.findByEmail(registroDto.getEmail()).isPresent()) {
            throw new IllegalStateException("El correo electrónico ya está registrado");
        }

        // 2. Crear una nueva instancia de Usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombreCompleto(registroDto.getNombreCompleto());
        nuevoUsuario.setEmail(registroDto.getEmail());

        // 3. Encriptar la contraseña antes de guardarla
        nuevoUsuario.setPassword(passwordEncoder.encode(registroDto.getPassword()));

        // 4. Guardar el nuevo usuario en la base de datos
        return usuarioRepository.save(nuevoUsuario);
    }
}