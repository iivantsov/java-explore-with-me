package ru.practicum.ewm.stat.exception;

public record ValidationExceptionResponse(String object, String field, String error) { }
