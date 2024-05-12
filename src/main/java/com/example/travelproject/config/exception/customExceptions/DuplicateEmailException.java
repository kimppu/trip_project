package com.example.travelproject.config.exception.customExceptions;

import org.springframework.dao.DuplicateKeyException;

import lombok.Getter;

@Getter
public class DuplicateEmailException extends DuplicateKeyException{
    public DuplicateEmailException(String msg) {
        super(msg);
    }
}
