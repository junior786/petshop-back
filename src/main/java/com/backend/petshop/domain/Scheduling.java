package com.backend.petshop.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Scheduling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Animal animal;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;
    private LocalDateTime time;
    private String status;
    @NotNull
    @Column(name = "procedure_info")
    private String procedure;
    @NotNull
    private Double price;
}
