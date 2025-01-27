package org.example.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.util.Utils;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public abstract class BaseDomain {

    private String id = Utils.generateId();
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

}
