package com.backend.petshop.domain.dto;

import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimalRequest {
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String sex;
    @NotBlank
    @NotNull
    private String race;
    @NotBlank
    @NotNull
    private String type;
    @NotBlank
    @NotNull
    private String description;
    @NotBlank
    @NotNull
    private String owner;
}
