package com.backend.petshop.exception.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetailsAdvanced extends ErrorDetails {
    private Map<String, String> errorsDetails;
}
