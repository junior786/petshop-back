package com.backend.petshop.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NotNull
public class OwnerResponse {
    private String name;
    private String cpf;
}
