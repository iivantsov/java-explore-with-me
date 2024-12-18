package ru.practicum.ewm.stat.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IpAddressValidator.class)
public @interface IpAddress {
    enum Type {
        V4
    }

    Type type();

    String message() default "{ru.practicum.ewm.validation - ip address is not valid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
