package com.distribuida.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "books")

@NamedQueries({@NamedQuery(name = "Book.findAll",
        query = "SELECT p FROM Book p")})
@Schema(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "isbn")
    @Schema(required = true)
    private String isbn;

    @Column(name = "title")
    @Schema(required = true)
    private String title;

    @Column(name = "author")
    @Schema(required = true)
    private String author;

    @Column(name = "price")
    @Schema(required = true)
    private Double price;
}
