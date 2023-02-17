package com.distribuida.test;

import com.distribuida.db.Book;
import com.distribuida.servicios.BookRepository;
import com.distribuida.servicios.BookRepositoryImpl;
import io.helidon.microprofile.config.ConfigCdiExtension;
import io.helidon.microprofile.tests.junit5.*;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@HelidonTest
@DisableDiscovery
@RequiredArgsConstructor
@AddExtension(ConfigCdiExtension.class)
@AddBeans({
        @AddBean(BookRepositoryImpl.class)
})
//
//@AddConfigs({
//        @AddConfig(key = "db.user", value = "postgres"),
//})
public class DatabaseTest {

    @Inject BookRepository repo;

    @Test
    void testPrueba() {

        Book book = repo.findById(10);

        assertEquals(true, book.getId() != null,"Book found");

        if(book != null) {
            assertEquals( 10, book.getId() );
        }
    }

    @Test
    void testPrueba2() {

        Book book = repo.findById(100);

        assertEquals(true, book.getId() != null,"Book found");

        if(book != null) {
            assertEquals( 10, book.getId() );
        }
    }
}
