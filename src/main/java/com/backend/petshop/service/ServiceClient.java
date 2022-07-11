package com.backend.petshop.service;

import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.dto.ClientRequest;
import com.backend.petshop.domain.dto.ClientResponse;
import com.backend.petshop.domain.mapper.ClientMapper;
import com.backend.petshop.repository.ClientRepository;
import com.backend.petshop.utils.UpdatesUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceClient {
    private final ClientRepository clientRepository;
    private final UpdatesUtils clientUtils;

    public void saveClient(Client client) {
        client.setAnimals(new ArrayList<>(1));
        this.clientRepository.save(client);
    }

    public void deleteClient(Integer client) {
        this.clientRepository.deleteById(client);
    }

    public List<ClientResponse> allClient() {
        return this.clientRepository.findAll().
                stream().map(ClientMapper::build).collect(Collectors.toList());
    }

    public Client selectByClient(Integer client) {
        return this.clientRepository.findById(client)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public ClientResponse updateById(ClientRequest client) {
        Client find = this.clientRepository.findById(client.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ClientMapper.build(this.clientRepository.save(this.clientUtils.clientUpdate(client, find)));
    }

}
