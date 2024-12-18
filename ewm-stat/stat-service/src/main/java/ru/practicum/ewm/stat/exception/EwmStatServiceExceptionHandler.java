package ru.practicum.ewm.stat.exception;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class EwmStatServiceExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse statExceptionHandler(Exception exception) {
        log.error("exception - {} ({})", exception.getMessage(), exception.getStackTrace()[0].toString());
        return new ExceptionResponse(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationExceptionResponse statRequestBodyExceptionHandler(MethodArgumentNotValidException exception) {
        List<ValidationExceptionResponse> response = exception.getBindingResult().getFieldErrors().stream()
                .map(er ->
                        new ValidationExceptionResponse(er.getObjectName(), er.getField(), er.getDefaultMessage()))
                .toList();
        log.error("request body validation exception - {}", response);
        return response.getFirst();
    }

    @ExceptionHandler(NotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse statNotValidExceptionHandler(NotValidException exception) {
        log.error("not valid exception - {} ({})", exception.getMessage(), exception.getStackTrace()[0].toString());
        return new ExceptionResponse(exception.getMessage());
    }
}
