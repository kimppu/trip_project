package com.example.travelproject.config.exception;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.travelproject.config.constant.EntityErrorCode;
import com.example.travelproject.config.exception.customExceptions.DuplicateEmailException;
import com.example.travelproject.config.exception.customExceptions.DuplicateIdException;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {
    //중복 회원 예외처리
    @ExceptionHandler(DuplicateIdException.class)
    public String handleHttpClientErrorException(DuplicateIdException e,RedirectAttributes redirectAttributes){
        log.error("[DuplicateMemberException : Conflict] cause: {}, message: {}",NestedExceptionUtils.getMostSpecificCause(e),e.getMessage());
        ErrorCode errorCode = EntityErrorCode.MEMBER_ID_ALREADY_EXISTS_ERROR;
        redirectAttributes.addAttribute("errorCode",errorCode.getCode());
        redirectAttributes.addAttribute("errorMessage", e.getMessage()+errorCode.getMessage());
        return "redirect:/error";
    }
    @ExceptionHandler(DuplicateEmailException.class)
    public String handleHttpClientErrorException(DuplicateEmailException e,RedirectAttributes redirectAttributes){
        ErrorCode errorCode = EntityErrorCode.MEMBER_EMAIL_ALREADY_EXISTS_ERROR;
        redirectAttributes.addAttribute("errorCode",errorCode.getCode());
        redirectAttributes.addAttribute("errorMessage", e.getMessage()+errorCode.getMessage());
        return "redirect:/error";
    }


    // @ExceptionHandler(EntityNotFoundException.class)
    // public String handleEntityNotFoundException(EntityNotFoundException e,RedirectAttributes redirectAttributes){
    //     log.error("[EntityNotFoundException] cause:{}, message: {}", NestedExceptionUtils.getMostSpecificCause(e),e.getMessage());
    //     ErrorCode errorCode = EntityErrorCode.MEMBER_NOT_FOUND_ERROR;
    //     redirectAttributes.addAttribute("errorCode",errorCode.getCode());
    //     redirectAttributes.addAttribute("errorMessage", errorCode.getMessage());
    //     return "redirect:/error";
    // }
}
