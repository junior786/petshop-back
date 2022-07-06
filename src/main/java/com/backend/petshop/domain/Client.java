package com.backend.petshop.domain;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Client  implements Serializable {
    @Id
    private  String id;
    @NotNull
    @NotBlank
    private String name;
    @CPF
    @NotBlank
    @NotNull
    private String cpf;
    @Email
    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private String telephone;
    @DBRef
    private List<Animal> animals = new ArrayList<Animal>();





}
