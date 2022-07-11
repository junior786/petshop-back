package com.backend.petshop.domain.mapper;

import com.backend.petshop.domain.Animal;
import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.Scheduling;
import com.backend.petshop.domain.dto.SchedulingRequest;
import com.backend.petshop.domain.dto.SchedulingResponse;

public class MapperScheduling {

    public static SchedulingResponse build(Scheduling scheduling) {
        return SchedulingResponse.builder()
                .id(scheduling.getId())
                .price(scheduling.getPrice())
                .procedure(scheduling.getProcedure())
                .status(scheduling.getStatus())
                .animal(AnimalMapper.buildAnimalResponse(scheduling.getAnimal()))
                .client(ClientMapper.build(scheduling.getClient()))
                .time(scheduling.getTime())
                .build();
    }

    public static Scheduling buildIntoRequest(SchedulingRequest request, Client client, Animal animal){
        return Scheduling.builder()
                .price(request.getPrice())
                .procedure(request.getProcedure())
                .time(request.getTime())
                .status(request.getStatus())
                .client(client)
                .animal(animal)
                .build();
    }
}
