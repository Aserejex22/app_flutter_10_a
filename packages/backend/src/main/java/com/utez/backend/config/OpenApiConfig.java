package com.utez.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API de Aplicación Flutter",
        version = "1.0.0",
        description = "Endpoints para la gestión de usuarios y otras funcionalidades de la app."
    )
)
public class OpenApiConfig {
}