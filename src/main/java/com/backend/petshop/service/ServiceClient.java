package com.backend.petshop.service;

import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.dto.ClientRequest;
import com.backend.petshop.domain.dto.ClientResponse;
import com.backend.petshop.domain.mapper.ClientMapper;
import com.backend.petshop.exception.NotFoundException;
import com.backend.petshop.repository.ClientRepository;
import com.backend.petshop.utils.UpdatesUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceClient {
    private final ClientRepository clientRepository;
    private final UpdatesUtils clientUtils;

    public Client saveClient(Client client) {
        client.setAnimals(new ArrayList<>(1));
        this.clientUtils.clientValid(client, clientRepository);
        return this.clientRepository.save(client);
    }

    public void deleteClient(Integer client) {
        this.clientRepository.deleteById(client);
    }

    public Page<ClientResponse> allClient(String cpf, Pageable pageable) {
        Page<Client> all = this.clientRepository.findAll(pageable);
        if (Objects.nonNull(cpf)) {
            return new PageImpl<>(this.clientRepository.findByCpfContains(cpf).stream().map(ClientMapper::build)
                    .toList(), pageable, all.getTotalElements());
        }


        return new PageImpl<>(all.stream().map(ClientMapper::build).toList(), pageable, all.getTotalElements());

    }

    public Client selectByClient(Integer client) {
        return this.clientRepository.findById(client)
                .orElseThrow(() -> new NotFoundException("ID not found " + client));
    }

    public ClientResponse updateById(ClientRequest client) {
        Client find = this.clientRepository.findById(client.getId())
                .orElseThrow(() -> new NotFoundException("ID not found " + client));
        return ClientMapper.build(this.clientRepository.save(this.clientUtils.clientUpdate(client, find)));
    }



}
