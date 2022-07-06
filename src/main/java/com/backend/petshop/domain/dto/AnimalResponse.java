package com.backend.petshop.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimalResponse {
    private String name;
    private String sex;
    private String race;
    private String type;
    private String description;
    private OwnerResponse Owner;
}


