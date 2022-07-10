package com.backend.petshop.domain.dto;

import com.backend.petshop.domain.Animal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponse {

    private Integer id;
    private String name;
    private String cpf;
    private String email;
    private String telephone;
    private List<AnimalOwner> animal;

    public static AnimalOwner getAnimalOwner(Animal animal){
        return AnimalOwner.builder()
                .id(animal.getId())
                .description(animal.getDescription())
                .race(animal.getRace())
                .sex(animal.getSex())
                .type(animal.getType())
                .name(animal.getName())
                .build();
    }
}
