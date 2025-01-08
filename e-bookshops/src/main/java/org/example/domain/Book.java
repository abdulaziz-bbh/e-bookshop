package org.example.domain;

import lombok.*;
import org.example.enums.BookType;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;
    private String name;
    private LocalDate releaseDate;
    private Author author;
    private Double price;
    private Integer available;
    private Integer soldCount;
    private BookType bookType;
}
