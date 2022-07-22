package com.backend.petshop.service;

import com.backend.petshop.domain.Animal;
import com.backend.petshop.domain.dto.SchedulingRequest;
import com.backend.petshop.domain.dto.SchedulingResponse;
import com.backend.petshop.domain.mapper.MapperScheduling;
import com.backend.petshop.repository.SchedulingRepository;
import com.backend.petshop.utils.ComparationsDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceScheduling {

    private final SchedulingRepository schedulingRepository;
    private final ServiceAnimal serviceAnimal;
    private final ComparationsDate dateComparation;

    public List<SchedulingResponse> findAll() {
        return this.schedulingRepository.findAll()
                .stream()
                .map(MapperScheduling::build)
                .toList();
    }

    public SchedulingResponse save(SchedulingRequest request) {
        Animal animal = this.serviceAnimal.selectById(request.getAnimal());
        if (request.getTime().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        this.schedulingRepository.findAll().forEach(scheduling ->
                this.dateComparation.dateCompare(request.getTime(), scheduling.getTime()));
        request.setStatus("ATIVO");
        return MapperScheduling.
                build(this.schedulingRepository
                        .save(MapperScheduling.buildIntoRequest(request, animal.getOwner(), animal)));
    }

    public void delete(Integer scheduling) {
        this.schedulingRepository.findById(scheduling)
                .ifPresentOrElse(sch -> this.schedulingRepository.deleteById(scheduling),
                        () -> log.error("Error id not exist"));
    }
}
