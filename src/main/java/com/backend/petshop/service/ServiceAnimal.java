package com.backend.petshop.service;

import com.backend.petshop.domain.Animal;
import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.dto.AnimalRequest;
import com.backend.petshop.domain.dto.AnimalResponse;
import com.backend.petshop.domain.dto.AnimalUpdateRequest;
import com.backend.petshop.domain.mapper.AnimalMapper;
import com.backend.petshop.exception.NotFoundException;
import com.backend.petshop.repository.AnimalRepository;
import com.backend.petshop.repository.ClientRepository;
import com.backend.petshop.utils.UpdatesUtils;
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
    private final UpdatesUtils animalUtils;


    public void registerAnimal(AnimalRequest animal) {
        Client client = this.clientRepository.findById(animal.getOwner())
                .orElseThrow(() -> new NotFoundException("ID not found " + animal.getOwner()));
        Animal save = this.animalRepository.save(AnimalMapper.build(animal, client));
        client.getAnimals().add(save);
        this.clientRepository.save(client);
    }

    public void deleteAnimal(Integer animal) {
        this.animalRepository.deleteById(animal);
    }

    public List<AnimalResponse> allAnimal() {
        return this.animalRepository.findAll()
                .stream().map(AnimalMapper::buildAnimalResponse).collect(Collectors.toList());
    }

    public Animal selectById(Integer animal) {
        return this.animalRepository.findById(animal)
                .orElseThrow(() -> new NotFoundException("ID not found " + animal));
    }

    public AnimalResponse updateAnimal(AnimalUpdateRequest animalRequest) {
        Animal animal = this.selectById(animalRequest.getId());
        return AnimalMapper
                .buildAnimalResponse(this.animalRepository.save(this.animalUtils.AnimalUpdate(animalRequest, animal)));
    }


}
