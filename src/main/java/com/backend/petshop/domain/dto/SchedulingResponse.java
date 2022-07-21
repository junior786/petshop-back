package com.backend.petshop.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingResponse {

    private Integer id;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime time;
    private String status;
    private String procedure;
    private Double price;
    private AnimalOwner animal;
    private OwnerResponse client;
}
