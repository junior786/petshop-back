package com.backend.petshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Animal {
    @Id
    private  String id;
    private String name;
    private String sex;
    private String race;
    private String type;
    private String description;
    @DBRef
    private Client owner;
    


    

}
