package com.weiz.commonservice.advice;

import com.weiz.commonservice.constant.AppConst;
import com.weiz.commonservice.model.error.ErrorResponse;
import com.weiz.commonservice.exception.BadRequestException;
import com.weiz.commonservice.exception.NotFoundException;
import com.weiz.commonservice.exception.ResourceConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionAdvice {

    private ResponseEntity<ErrorResponse> badRequest(ErrorResponse result) {
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponse> internalServerError(ErrorResponse result) {
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> notFound(ErrorResponse result) {
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorResponse> conflict(ErrorResponse result) {
        return new ResponseEntity<>(result, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalException(Exception e) {

        return internalServerError(
                new ErrorResponse(AppConst.SERVICE_ERROR.getCode(), AppConst.SERVICE_ERROR.getMessage())
        );
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {

        Map<String, Object> map = new HashMap<>();
        map.put("service", e.getMessage());

        return badRequest(
                new ErrorResponse(AppConst.BAD_REQUEST.getCode(), AppConst.BAD_REQUEST.getMessage(), map)
        );
    }

    @ExceptionHandler(ResourceConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorResponse> handleConflictException(ResourceConflictException e) {

        Map<String, Object> map = new HashMap<>();
        map.put("resource", e.getMessage());

        return conflict(
                new ErrorResponse(AppConst.CONFLICT.getCode(), AppConst.CONFLICT.getMessage(), map)
        );
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {

        Map<String, Object> map = new HashMap<>();
        map.put("resource", e.getMessage());

        return notFound(
                new ErrorResponse(AppConst.NOT_FOUND.getCode(), AppConst.NOT_FOUND.getMessage(), map)
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        final Map<String, Object> objResult = new HashMap<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            objResult.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        final ErrorResponse response = new ErrorResponse(AppConst.BAD_REQUEST.getCode(),
                "Validation exception", objResult);

        return badRequest(response);
    }
}
