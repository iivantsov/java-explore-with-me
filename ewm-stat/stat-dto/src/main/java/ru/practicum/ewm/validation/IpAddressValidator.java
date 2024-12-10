package ru.practicum.ewm.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class IpAddressValidator implements ConstraintValidator<IpAddress, String> {
    static private final Pattern V4_PATTERN = Pattern.compile("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$");
    private IpAddress.Type type;

    @Override
    public void initialize(IpAddress constraintAnnotation) {
        type = constraintAnnotation.type();
    }

    @Override
    public boolean isValid(String ip, ConstraintValidatorContext constraintValidatorContext) {
        switch (type) {
            case V4 -> {
                return (ip != null) && V4_PATTERN.matcher(ip).matches();
            }
            default -> throw new UnsupportedOperationException("Unsupported IP address type");
        }
    }
}
