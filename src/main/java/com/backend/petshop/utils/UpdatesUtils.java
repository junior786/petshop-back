package com.backend.petshop.utils;

import com.backend.petshop.domain.Animal;
import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.dto.AnimalUpdateRequest;
import com.backend.petshop.domain.dto.ClientRequest;
import com.backend.petshop.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class UpdatesUtils {

    public Client clientUpdate(ClientRequest clientRequest, Client client) {
        if (Objects.nonNull(clientRequest.getCpf())) {
            client.setCpf(clientRequest.getCpf());
        }
        if (Objects.nonNull(clientRequest.getEmail())) {
            client.setEmail(clientRequest.getEmail());
        }
        if (Objects.nonNull(clientRequest.getName())) {
            client.setName(clientRequest.getName());
        }
        if (Objects.nonNull(clientRequest.getTelephone())) {
            client.setTelephone(clientRequest.getTelephone());
        }
        return client;
    }

    public void clientValid(Client clientRequest, ClientRepository clientRepository) {
        if (clientRepository.findByEmail(clientRequest.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (clientRepository.findByCpf(clientRequest.getCpf()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public Animal AnimalUpdate(AnimalUpdateRequest animalUpdateRequest, Animal animal) {
        if (Objects.nonNull(animalUpdateRequest.getDescription())) {
            animal.setDescription(animalUpdateRequest.getDescription());
        }
        if (Objects.nonNull(animalUpdateRequest.getName())) {
            animal.setName(animalUpdateRequest.getName());
        }
        if (Objects.nonNull(animalUpdateRequest.getRace())) {
            animal.setRace(animalUpdateRequest.getRace());
        }
        if (Objects.nonNull(animalUpdateRequest.getType())) {
            animal.setRace(animalUpdateRequest.getType());
        }
        return animal;
    }
}
