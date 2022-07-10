package com.backend.petshop.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AnimalUpdateRequest {
    @NotNull
    private Integer id;
    private String name;
    private String sex;
    private String race;
    private String type;
    private String description;
}
