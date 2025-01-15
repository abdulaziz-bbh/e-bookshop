package org.example.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class BaseDomain {

    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
