package com.backend.petshop.domain.dto;

import com.backend.petshop.domain.Animal;
import com.backend.petshop.domain.Client;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchedulingRequest {

    @NotNull
    private Integer animal;
    @NotNull
    private Integer client;
    private LocalDateTime time;
    private String status;
    @NotNull
    private String procedure;
    @NotNull
    private Double price;
}
