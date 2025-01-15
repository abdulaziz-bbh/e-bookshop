package org.example.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Book extends BaseDomain {

    private String name;
    private String releaseYear;
    private String publisher;
    private Integer availableCount;
    private Integer soldCount;
    private Double price;
    private Author author;


}
