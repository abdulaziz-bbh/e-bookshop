package org.example.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.util.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Author extends BaseDomain {

    private String id = Utils.generateId();
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private String fullName;
    private LocalDate birthday;
    private LocalDate deathDate;
    private String country;
    private String biography;

    public Author(String fullName, LocalDate birthdate, LocalDate deathDate, String country, String biography) {
        this.fullName = fullName;
        this.birthday = birthdate;
        this.deathDate = deathDate;
        this.country = country;
        this.biography = biography;
    }
}
