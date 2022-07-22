package com.backend.petshop.utils;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Component
public class ComparationsDate {

    public void dateCompare(LocalDateTime request, LocalDateTime condition) {
        if (request.isEqual(condition)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}

