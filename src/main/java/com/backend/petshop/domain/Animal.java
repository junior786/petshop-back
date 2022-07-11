package com.backend.petshop.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String sex;
    private String race;
    private String type;
    private String description;
    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "scheduling_id")
    private Set<Scheduling> schedulings;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Client owner;
}
