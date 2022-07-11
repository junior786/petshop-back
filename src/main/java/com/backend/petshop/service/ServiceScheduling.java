package com.backend.petshop.service;

import com.backend.petshop.domain.Animal;
import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.dto.SchedulingRequest;
import com.backend.petshop.domain.dto.SchedulingResponse;
import com.backend.petshop.domain.mapper.MapperScheduling;
import com.backend.petshop.repository.SchedulingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceScheduling {

    private final SchedulingRepository schedulingRepository;
    private final ServiceClient serviceClient;
    private final ServiceAnimal serviceAnimal;


    public List<SchedulingResponse> findAll() {
        return this.schedulingRepository.findAll()
                .stream()
                .map(MapperScheduling::build)
                .toList();
    }

    public SchedulingResponse save(SchedulingRequest request) {
        Client client = this.serviceClient.selectByClient(request.getClient());
        Animal animal = this.serviceAnimal.selectById(request.getAnimal());
        request.setTime(LocalDateTime.now());
        request.setStatus("ATIVO");
        return MapperScheduling.
                build(this.schedulingRepository.save(MapperScheduling.buildIntoRequest(request, client, animal)));
    }

}
