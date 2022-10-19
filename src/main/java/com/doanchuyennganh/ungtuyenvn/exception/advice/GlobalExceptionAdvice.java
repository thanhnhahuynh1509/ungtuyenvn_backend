package com.doanchuyennganh.ungtuyenvn.exception.advice;

import com.doanchuyennganh.ungtuyenvn.exception.model.NotFoundException;
import com.doanchuyennganh.ungtuyenvn.exception.model.UserExistsException;
import com.doanchuyennganh.ungtuyenvn.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleException(NotFoundException ex, WebRequest request) {
        return ExceptionResponse.builder()
                .withMessage(ex.getMessage())
                .withStatus(HttpStatus.NOT_FOUND.value())
                .withTimestamp(new SimpleDateFormat("yyyy/MM/dd").format(new Date()))
                .withUrl(request.getDescription(false))
                .build();
    }

    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleException(UserExistsException ex, WebRequest request) {
        return ExceptionResponse.builder()
                .withMessage(ex.getMessage())
                .withStatus(HttpStatus.BAD_REQUEST.value())
                .withTimestamp(new SimpleDateFormat("yyyy/MM/dd").format(new Date()))
                .withUrl(request.getDescription(false))
                .build();
    }

}
