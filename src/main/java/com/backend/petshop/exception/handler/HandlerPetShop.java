package com.backend.petshop.exception.handler;

import com.backend.petshop.exception.NotFoundException;
import com.backend.petshop.exception.model.ErrorDetails;
import com.backend.petshop.exception.model.ErrorDetailsAdvanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
public class HandlerPetShop {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDetailsAdvanced argumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException) {
        HashMap<String, String> errors = new HashMap<>(1);
        methodArgumentNotValidException.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ErrorDetailsAdvanced
                .builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Parameter not found")
                .localDateTime(LocalDateTime.now())
                .errorsDetails(errors)
                .build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDetails httpMessageNotReadable (HttpMessageNotReadableException httpMessageNotReadableException) {
        return ErrorDetails
                .builder()
                .message("JSON warning")
                .localDateTime(LocalDateTime.now())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorDetails httpMessageNotReadable (NotFoundException notFoundException) {
        return ErrorDetails
                .builder()
                .message(notFoundException.getMessage())
                .localDateTime(LocalDateTime.now())
                .code(HttpStatus.NOT_FOUND.value())
                .build();
    }


}
