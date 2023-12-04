package com.epita.spring.tphotelmanagement.application.exceptions;

public class EntityFormatException extends IllegalStateException{

    public EntityFormatException(String s) {
        super(s);
    }
}
