package com.backend.petshop.controller;

import com.backend.petshop.domain.Client;
import com.backend.petshop.domain.dto.ClientRequest;
import com.backend.petshop.domain.dto.ClientResponse;
import com.backend.petshop.service.ServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/client")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClientController {
    private final ServiceClient serviceClient;

    @PostMapping
    public Client saveClient(@Valid @RequestBody Client client){
      return  this.serviceClient.saveClient(client);
    }

    @GetMapping
    public Page<ClientResponse> findAll(@RequestParam(required = false) String cpf,
                                        Pageable pageable) {
        return this.serviceClient.allClient(cpf, pageable);

    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.serviceClient.deleteClient(id);
    }

    @PatchMapping
    public ClientResponse edit(@RequestBody @Valid ClientRequest clientRequest){
        return this.serviceClient.updateById(clientRequest);
    }


}
