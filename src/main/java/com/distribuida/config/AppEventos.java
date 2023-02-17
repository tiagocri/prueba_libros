package com.distribuida.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;

import javax.sql.DataSource;

@ApplicationScoped
@RequiredArgsConstructor
public class AppEventos {


    @Inject DataSource dataSource;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object event ) {

        var flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.migrate();
    }
}
