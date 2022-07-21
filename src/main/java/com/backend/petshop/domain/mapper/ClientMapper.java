package com.backend.petshop.domain.mapper;

import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.dto.ClientResponse;
import com.backend.petshop.domain.dto.OwnerResponse;

import java.util.stream.Collectors;

public class ClientMapper {

    public static ClientResponse build(Client client) {
        return ClientResponse.builder()
                .animal(client.getAnimals().stream().map(ClientResponse::getAnimalOwner).collect(Collectors.toList()))
                .cpf(client.getCpf())
                .id(client.getId())
                .email(client.getEmail())
                .name(client.getName())
                .telephone(client.getTelephone())
                .build();
    }

    public static OwnerResponse toOwner(Client client) {
        return OwnerResponse.builder()
                .name(client.getName())
                .cpf(client.getCpf())
                .id(client.getId())
                .build();
    }
}
