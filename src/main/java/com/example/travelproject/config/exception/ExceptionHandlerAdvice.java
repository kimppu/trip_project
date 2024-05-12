package com.example.travelproject.config.exception;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.travelproject.config.constant.CommonErrorCode;
import com.example.travelproject.config.constant.EntityErrorCode;
import com.example.travelproject.config.exception.customExceptions.DuplicateEmailException;
import com.example.travelproject.config.exception.customExceptions.DuplicateIdException;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {
        //모든 에러 -> 하위 에러에서 못받을 때
        @ExceptionHandler(Exception.class)
        public ResponseEntity handleException(Exception e){
            // NestedExceptionUtils.getMostSpecificCause() -> 가장 구체적인 원인, 즉 가장 근본 원인을 찾아서 반환
            log.error("[Exception] cause: {} , message: {}", NestedExceptionUtils.getMostSpecificCause(e), e.getMessage());
            ErrorCode errorCode = CommonErrorCode.INTERNAL_SERVER_ERROR;
            ErrorResponse errorResponse = ErrorResponse.of(errorCode.getHttpStatus(), errorCode.getCode(), errorCode.getMessage());
            return ResponseEntity.status(errorCode.getHttpStatus()).body(errorResponse);
        }
    
        @ExceptionHandler(RestApiException.class)
        public ResponseEntity handleSystemException(RestApiException e){
            log.error("[SystemException] cause: {}, message: {}",NestedExceptionUtils.getMostSpecificCause(e),e.getMessage());
            ErrorCode errorCode = e.getErrorCode();
            ErrorResponse errorResponse = ErrorResponse.of(errorCode.getHttpStatus(),errorCode.getCode(),  errorCode.getMessage());
            return ResponseEntity.status(errorCode.getHttpStatus()).body(errorResponse);
        }
    
        //메소드가 잘못되었거나 부적합한 인수를 전달했을 경우 -> 필수 파라미터 없을 때
        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity handleIllegalArgumentException(IllegalArgumentException e){
            log.error("[IlleagalArgumentException] cause: {} , message: {}",NestedExceptionUtils.getMostSpecificCause(e),e.getMessage());
            ErrorCode errorCode = CommonErrorCode.ILLEGAL_ARGUMENT_ERROR;
            ErrorResponse errorResponse = ErrorResponse.of(errorCode.getHttpStatus(),errorCode.getCode(),errorCode.getMessage());
            return ResponseEntity.status(errorCode.getHttpStatus()).body(errorResponse);
        }
    
        //@Valid 유효성 검사에서 예외가 발생했을 때 -> requestbody에 잘못 들어왔을 때
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
            log.error("[MethodArgumentNotValidException] cause: {}, message: {}",NestedExceptionUtils.getMostSpecificCause(e),e.getMessage());
            ErrorCode errorCode = CommonErrorCode.INVALID_ARGUMENT_ERROR;
            ErrorResponse errorResponse = ErrorResponse.of(errorCode.getHttpStatus(),
                    errorCode.getCode(),
                    errorCode.getMessage(),
                    e.getBindingResult());
            return ResponseEntity.status(errorCode.getHttpStatus()).body(errorResponse);
        }
    
        //잘못된 포맷 요청 -> Json으로 안보내다던지
        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
            log.error("[HttpMessageNotReadableException] cause: {}, message: {}",NestedExceptionUtils.getMostSpecificCause(e),e.getMessage());
            ErrorCode errorCode = CommonErrorCode.INVALID_FORMAT_ERROR;
            ErrorResponse errorResponse = ErrorResponse.of(errorCode.getHttpStatus(), errorCode.getCode(),  errorCode.getMessage());
            return ResponseEntity.status(errorCode.getHttpStatus()).body(errorResponse);
        }
    
        //중복 회원 예외처리
        // @ExceptionHandler(DuplicateIdException.class)
        // public ResponseEntity handleHttpClientErrorException(DuplicateIdException e){
        //         log.error("[DuplicateMemberException : Conflict] cause: {}, message: {}",NestedExceptionUtils.getMostSpecificCause(e),e.getMessage());
        //         ErrorCode errorCode = EntityErrorCode.MEMBER_ID_ALREADY_EXISTS_ERROR;
        //         ErrorResponse errorResponse = ErrorResponse.of(errorCode.getHttpStatus(),errorCode.getCode(), e.getMessage()+ errorCode.getMessage());
        //         return ResponseEntity.status(errorCode.getHttpStatus()).body(errorResponse);
        // }
        
        // @ExceptionHandler(DuplicateEmailException.class)
        // public ResponseEntity handleHttpClientErrorException(DuplicateEmailException e){
        //         log.error("[DuplicateMemberException : Conflict] cause: {}, message: {}",NestedExceptionUtils.getMostSpecificCause(e),e.getMessage());
        //         ErrorCode errorCode = EntityErrorCode.MEMBER_ID_ALREADY_EXISTS_ERROR;
        //         ErrorResponse errorResponse = ErrorResponse.of(errorCode.getHttpStatus(),errorCode.getCode(), e.getMessage()+ errorCode.getMessage());
        //         return ResponseEntity.status(errorCode.getHttpStatus()).body(errorResponse);
        // }


        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity handleEntityNotFoundException(EntityNotFoundException e){
            log.error("[EntityNotFoundException] cause:{}, message: {}", NestedExceptionUtils.getMostSpecificCause(e),e.getMessage());
            ErrorCode errorCode = EntityErrorCode.MEMBER_NOT_FOUND_ERROR;
            ErrorResponse errorResponse = ErrorResponse.of(errorCode.getHttpStatus(),errorCode.getCode(), errorCode.getMessage());
            return ResponseEntity.status(errorCode.getHttpStatus()).body(errorResponse);
        }
    
}
