package com.backend.petshop.repository;

import com.backend.petshop.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findAllByEmail(String email);
    List<Client> findAllByCpf(String cpf);
}
