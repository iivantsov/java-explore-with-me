package ru.practicum.ewm.main.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Class<?> entity, Object id) {
        super(entity.getSimpleName() + " with id " + id + " not found");
    }
}