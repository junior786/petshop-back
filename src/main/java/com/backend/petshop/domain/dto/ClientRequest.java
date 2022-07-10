package com.backend.petshop.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientRequest {
    @NotNull
    private Integer id;
    private String name;
    private String cpf;
    private String email;
    private String telephone;
}
