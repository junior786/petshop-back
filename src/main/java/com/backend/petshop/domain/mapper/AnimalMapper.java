package com.backend.petshop.domain.mapper;

import com.backend.petshop.domain.Animal;
import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.dto.AnimalOwner;
import com.backend.petshop.domain.dto.AnimalRequest;
import com.backend.petshop.domain.dto.AnimalResponse;
import com.backend.petshop.domain.dto.OwnerResponse;

public class AnimalMapper {

    public static Animal build(AnimalRequest animalRequest, Client client) {
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
                .id(animal.getOwner().getId())
                .cpf(animal.getOwner().getCpf())
                .name(animal.getOwner().getName())
                .build();

        return AnimalResponse.builder()
                .Owner(cliente)
                .id(animal.getId())
                .name(animal.getName())
                .race(animal.getRace())
                .description(animal.getDescription())
                .sex(animal.getSex())
                .type(animal.getType())
                .build();
    }

    public static AnimalOwner toAnimalOwner(Animal animal) {
        return AnimalOwner.builder()
                .name(animal.getName())
                .type(animal.getType())
                .sex(animal.getSex())
                .race(animal.getRace())
                .description(animal.getDescription())
                .id(animal.getId())
                .build();
    }

}
