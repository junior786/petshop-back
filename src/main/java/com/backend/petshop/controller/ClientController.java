package com.backend.petshop.controller;

import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.dto.ClientResponse;
import com.backend.petshop.service.ServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    private final ServiceClient serviceClient;

    @PostMapping
    public void saveClient(@Valid @RequestBody Client client){
        this.serviceClient.saveClient(client);
    }

    @GetMapping
    public List<ClientResponse> findAll() {
        return this.serviceClient.allClient();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.serviceClient.deleteClient(id);
    }

}
