package ru.practicum.ewm.exception;

public record ValidationExceptionResponse(String object, String field, String error) { }
