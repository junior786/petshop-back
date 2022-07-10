package com.backend.petshop.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String sex;
    private String race;
    private String type;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client owner;


}
