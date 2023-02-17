package com.distribuida;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationPath("/")
@OpenAPIDefinition(
        info = @Info(
                title="CRUD de Libros", version = "1.0.0"
        )
)
public class RestApp extends Application {
}
