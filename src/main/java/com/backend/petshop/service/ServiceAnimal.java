package com.backend.petshop.service;

import com.backend.petshop.domain.Animal;
import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.dto.AnimalRequest;
import com.backend.petshop.domain.dto.AnimalResponse;
import com.backend.petshop.domain.mapper.AnimalMapper;
import com.backend.petshop.repository.AnimalRepository;
import com.backend.petshop.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceAnimal {
    private final AnimalRepository animalRepository;
    private final ClientRepository clientRepository;

    public void registerAnimal(AnimalRequest animal) {
        Client client = this.clientRepository.findById(animal.getOwner())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client nao encontrado"));
        Animal save = this.animalRepository.save(AnimalMapper.build(animal, client));
//        client.getAnimals().add(save);
//        this.clientRepository.save(client);
    }

    public void deleteAnimal(Animal animal) {
        this.animalRepository.delete(animal);
    }

    public List<AnimalResponse> allAnimal() {
        return this.animalRepository.findAll()
                .stream().map(AnimalMapper::buildAnimalResponse).collect(Collectors.toList());

    }

    public Animal selectById(Animal animal) {
        return this.animalRepository.findById(animal.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
