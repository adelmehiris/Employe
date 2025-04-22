package fr.milleis.test.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Test API",
                version = "1.0",
                description = "Documentation de l'API test"
        )
)
public class SwaggerConfig {
}
