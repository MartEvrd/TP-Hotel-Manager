package com.epita.spring.tphotelmanagement.application.exceptions;

import jakarta.persistence.EntityExistsException;

public class ReservationDatesException extends Exception {

    public ReservationDatesException(String message) {
        super(message);
    }
}
