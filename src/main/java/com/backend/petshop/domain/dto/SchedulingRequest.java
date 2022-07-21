package com.backend.petshop.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchedulingRequest {

    @NotNull
    private Integer animal;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime time;
    private String status;
    @NotNull
    private String procedure;
    @NotNull
    private Double price;
}
