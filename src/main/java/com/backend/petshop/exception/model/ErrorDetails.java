package com.backend.petshop.exception.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private String message;
    private Integer code;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime localDateTime;

}

