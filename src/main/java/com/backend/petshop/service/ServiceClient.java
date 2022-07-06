package com.backend.petshop.service;

import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.dto.ClientResponse;
import com.backend.petshop.domain.mapper.ClientMapper;
import com.backend.petshop.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceClient {
    private final ClientRepository clientRepository;


    public void saveClient(Client client) {
        client.setAnimals(new ArrayList<>(1));
        this.clientRepository.save(client);
    }

    public void deleteClient(String client) {
        this.clientRepository.deleteById(client);
    }

    public List<ClientResponse> allClient() {
        return this.clientRepository.findAll().
                stream().map(ClientMapper::build).collect(Collectors.toList());
    }

    public Client selectByClient(Client client) {
        return this.clientRepository.findById(client.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
