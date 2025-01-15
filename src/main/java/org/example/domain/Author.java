package org.example.domain;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Author extends BaseDomain {

    private String fullName;
    private LocalDate birthday;
    private LocalDate deathDate;
    private String country;
    private String biography;
}
