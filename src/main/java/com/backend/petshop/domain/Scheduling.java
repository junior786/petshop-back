package com.backend.petshop.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Document
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Scheduling {
    @Id
    private ObjectId id;
    @NotBlank
    @NotNull
    private Animal animal;
    @NotBlank
    @NotNull
    private Client client;
    private LocalDateTime time;
    @NotBlank
    @NotNull
    private String procedure;
    @NotBlank
    @NotNull
    private Double price;

}
