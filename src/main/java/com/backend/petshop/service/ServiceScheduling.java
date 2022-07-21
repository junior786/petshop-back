package com.backend.petshop.service;

import com.backend.petshop.domain.Animal;
import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.dto.SchedulingRequest;
import com.backend.petshop.domain.dto.SchedulingResponse;
import com.backend.petshop.domain.mapper.MapperScheduling;
import com.backend.petshop.repository.SchedulingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceScheduling {

    private final SchedulingRepository schedulingRepository;
    private final ServiceAnimal serviceAnimal;


    public List<SchedulingResponse> findAll() {
        return this.schedulingRepository.findAll()
                .stream()
                .peek(scheduling -> {
                    var date = "";
                    date = String.valueOf(scheduling.getTime().getDayOfMonth());
                    date += " / " + scheduling.getTime().getMonth().getValue();
                    date += " " + scheduling.getTime().getHour();
                    log.info("TEMPO {}", date);
                })
                .map(MapperScheduling::build)
                .toList();
    }

    public SchedulingResponse save(SchedulingRequest request) {
        Animal animal = this.serviceAnimal.selectById(request.getAnimal());
        log.info("Animal {} ", animal);
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
