package org.example.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Author {

    private Long id;
    private String fullName;
    private LocalDate birthDate;
    private String bio;

}
