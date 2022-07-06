package com.backend.petshop.domain.mapper;

import com.backend.petshop.domain.Animal;
import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.dto.AnimalRequest;
import com.backend.petshop.domain.dto.AnimalResponse;
import com.backend.petshop.domain.dto.OwnerResponse;

public class AnimalMapper {

    public static Animal build(AnimalRequest animalRequest, Client client){
        return Animal.builder()
                .description(animalRequest.getDescription())
                .owner(client)
                .race(animalRequest.getRace())
                .sex(animalRequest.getSex())
                .type(animalRequest.getType())
                .name(animalRequest.getName())
                .build();
    }

    public static AnimalResponse buildAnimalResponse(Animal animal) {
        OwnerResponse cliente = OwnerResponse.builder()
                .cpf(animal.getOwner().getCpf())
                .name(animal.getOwner().getName())
                .build();

        return AnimalResponse.builder()
                .Owner(cliente)
                .name(animal.getName())
                .race(animal.getRace())
                .description(animal.getDescription())
                .sex(animal.getSex())
                .type(animal.getType())
                .build();
    }
}
