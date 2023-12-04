package com.epita.spring.tphotelmanagement.exposition.exception;

import com.epita.spring.tphotelmanagement.application.exceptions.EntityFormatException;
import com.epita.spring.tphotelmanagement.application.exceptions.ReservationDatesException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Map<String, List<Map<String, String>>> getErrorsMap(List<Map<String, String>> errors){
        Map<String,List<Map<String, String>>>  errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ExceptionDto> handleFilmFormatException(EntityExistsException ex){
        ExceptionDto dto = new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage(), new Date(), "BAD_REQUEST");
        return new ResponseEntity<ExceptionDto>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleFilmFormatException(EntityNotFoundException ex){
        ExceptionDto dto = new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage(), new Date(), "BAD_REQUEST");
        return new ResponseEntity<ExceptionDto>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReservationDatesException.class)
    public ResponseEntity<ExceptionDto> handleReservationDatesException(ReservationDatesException ex){
        ExceptionDto dto = new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage(), new Date(), "BAD_REQUEST");
        return new ResponseEntity<ExceptionDto>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityFormatException.class)
    public ResponseEntity<ExceptionDto> handleEntityFormatException(EntityFormatException ex){
        ExceptionDto dto = new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage(), new Date(), "BAD_REQUEST");
        return new ResponseEntity<ExceptionDto>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionDto> handleIllegalArgeumentException(IllegalArgumentException ex){
        ExceptionDto dto = new ExceptionDto(ex.getClass().getSimpleName(), ex.getMessage(), new Date(), "BAD_REQUEST");
        return new ResponseEntity<ExceptionDto>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<Map<String, String>>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(f -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(f.getField(), f.getDefaultMessage());
                    return error;
                })
                .toList();
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
