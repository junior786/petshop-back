package com.backend.petshop.repository;

import com.backend.petshop.domain.Scheduling;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends MongoRepository<Scheduling, String> {
}
