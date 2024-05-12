package com.example.travelproject.config.exception.customExceptions;

import org.springframework.dao.DuplicateKeyException;

import lombok.Getter;

@Getter
public class DuplicateIdException extends DuplicateKeyException{
    public DuplicateIdException(String msg) {
        super(msg);
    }
}
