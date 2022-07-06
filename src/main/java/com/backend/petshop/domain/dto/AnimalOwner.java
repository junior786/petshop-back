package com.backend.petshop.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalOwner {
    private  String id;
    private String name;
    private String sex;
    private String race;
    private String type;
    private String description;
}