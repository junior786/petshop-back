package com.backend.petshop.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Scheduling {
    private Integer id;
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
