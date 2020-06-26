package com.astroviking.pawpals.controllers;

import com.astroviking.pawpals.exceptions.ConflictingResourceException;
import com.astroviking.pawpals.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ResourceNotFoundException.class)
  public void handleNotFound() {

  }

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(ConflictingResourceException.class)
  public void handleResourceAlreadyExists() {

  }
}
