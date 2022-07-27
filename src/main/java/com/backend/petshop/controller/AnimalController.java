package com.backend.petshop.controller;

import com.backend.petshop.domain.dto.AnimalRequest;
import com.backend.petshop.domain.dto.AnimalResponse;
import com.backend.petshop.domain.dto.AnimalUpdateRequest;
import com.backend.petshop.service.ServiceAnimal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/animal")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AnimalController {
    private final ServiceAnimal serviceAnimal;

    @PostMapping
    public void saveAnimal (@RequestBody @Valid AnimalRequest animal){
        this.serviceAnimal.registerAnimal(animal);
    }

    @GetMapping
    public List<AnimalResponse> getAll(){
        return this.serviceAnimal.allAnimal();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        this.serviceAnimal.deleteAnimal(id);
    }

    @PatchMapping
    public AnimalResponse edit(@RequestBody @Valid AnimalUpdateRequest animalUpdateRequest) {
        return this.serviceAnimal.updateAnimal(animalUpdateRequest);
    }

}
