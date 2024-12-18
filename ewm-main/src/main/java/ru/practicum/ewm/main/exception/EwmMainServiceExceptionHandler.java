package ru.practicum.ewm.main.exception;

import ru.practicum.ewm.stat.exception.ApiError;
import ru.practicum.ewm.stat.exception.ValidationExceptionResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class EwmMainServiceExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError mainExceptionHandler(Exception exception) {
        log.error("exception - {} ({})", exception.getMessage(), exception.getStackTrace()[0].toString());
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Internal error",
                exception.getMessage(),
                exception.getStackTrace()[0].toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError mainRequestBodyExceptionHandler(MethodArgumentNotValidException exception) {
        List<ValidationExceptionResponse> response = exception.getBindingResult().getFieldErrors().stream()
                .map(er ->
                        new ValidationExceptionResponse(er.getObjectName(), er.getField(), er.getDefaultMessage()))
                .toList();
        log.error("request body validation exception - {}", response);
        return new ApiError(HttpStatus.BAD_REQUEST.toString(), "incorrectly made request",
                exception.getMessage(),
                exception.getStackTrace()[0].toString());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError mainNotFoundExceptionHandler(NotFoundException exception) {
        log.error("not found exception - {} ({})", exception.getMessage(), exception.getStackTrace()[0].toString());
        return new ApiError(HttpStatus.NOT_FOUND.toString(), "the required object was not found",
                exception.getMessage(),
                exception.getStackTrace()[0].toString());
    }
}
