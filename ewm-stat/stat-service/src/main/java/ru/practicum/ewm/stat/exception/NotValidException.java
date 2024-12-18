package ru.practicum.ewm.stat.exception;

public class NotValidException extends RuntimeException {

    public NotValidException(Class<?> entity, String reason) {
        super(entity.getSimpleName() + " " + reason);
    }
}

