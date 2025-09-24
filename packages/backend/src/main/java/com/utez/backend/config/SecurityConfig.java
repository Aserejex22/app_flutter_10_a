package com.utez.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Usamos BCrypt para encriptar las contraseñas. Es el estándar actual.
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Deshabilitamos CSRF porque nuestra API será stateless (sin estado)
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // Permitimos el acceso sin autenticación a estos endpoints:
                .requestMatchers(
                    "/api/usuarios/registrar", // Nuestro endpoint de registro
                    "/v3/api-docs/**",         // Documentación de Swagger
                    "/swagger-ui/**",         // UI de Swagger
                    "/swagger-ui.html"
                ).permitAll()
                // Cualquier otra solicitud requiere autenticación
                .anyRequest().authenticated()
            );

        return http.build();
    }
}