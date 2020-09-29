package com.investec.transactions.controller.model;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomeRestExceptionHandler extends ResponseEntityExceptionHandler {

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

            List<String> errors = new ArrayList<>();

            for (FieldError error : ex.getBindingResult().getFieldErrors()) {
                errors.add(error.getDefaultMessage());
            }

            for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
                errors.add(error.getDefaultMessage());
            }
            Response response = new Response(errors.get(0));

            return handleExceptionInternal(ex, response, headers, HttpStatus.BAD_REQUEST, request);
        }
    }


