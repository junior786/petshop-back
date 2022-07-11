package com.backend.petshop.domain.dto;

import com.backend.petshop.domain.Animal;
import com.backend.petshop.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingResponse {

    private Integer id;
    private LocalDateTime time;
    private String status;
    private String procedure;
    private Double price;
    private AnimalResponse animal;
    private ClientResponse client;
}
