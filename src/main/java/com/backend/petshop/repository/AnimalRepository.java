package com.backend.petshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.petshop.domain.Animal;

@Repository
public interface AnimalRepository extends MongoRepository<Animal, String> {
}
