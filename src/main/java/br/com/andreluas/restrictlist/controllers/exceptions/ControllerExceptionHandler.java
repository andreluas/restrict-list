package br.com.andreluas.restrictlist.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.andreluas.restrictlist.services.exceptions.ExistsCpfException;
import br.com.andreluas.restrictlist.services.exceptions.NotFoundCpfException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundCpfException.class)
    public ResponseEntity<StandardError> entityNotFound(NotFoundCpfException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError();
        err.setType("NotFoundCpfException");
        err.setMessage("CPF not found.");
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ExistsCpfException.class)
    public ResponseEntity<StandardError> entityNotFound(ExistsCpfException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError();
        err.setType("ExistsCpfException");
        err.setMessage("CPF already existing in database.");
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError();
        err.setType("InvalidCpfException");
        err.setMessage("CPF is not valid.");

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            err.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> validation(ConstraintViolationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        StandardError err = new StandardError();
        err.setType("InvalidCpfException");
        err.setMessage("CPF is not valid.");
        return ResponseEntity.status(status).body(err);
    }
}
