package ru.practicum.ewm.stat.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.practicum.ewm.stat.dto.StatSaveDto;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatSaveDtoTest {
    private final Validator validator;
    private StatSaveDto statSaveDto;

    public StatSaveDtoTest() {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    @BeforeEach
    public void testInit() {
        // Create a valid instance
        statSaveDto = new StatSaveDto();
        statSaveDto.setApp("ewm-main-service");
        statSaveDto.setUri("/events/1");
        statSaveDto.setIp("192.163.0.1");
        statSaveDto.setTimestamp(LocalDateTime.now());
    }

    @AfterEach
    public void checkResult() {
        Set<ConstraintViolation<StatSaveDto>> violations = validator.validate(statSaveDto);
        assertEquals(1, violations.size());
    }

    @Test
    public void testStatSaveDtoWithNullIpAddressDoesNotPassValidation() {
        statSaveDto.setIp(null);
    }

    @Test
    public void testStatSaveDtoWithTextInsteadOfIpAddressDoesNotPassValidation() {
        statSaveDto.setIp("ip-address");
    }

    @Test
    public void testStatSaveDtoWithInvalidIpV4AddressDoesNotPassValidation() {
        statSaveDto.setIp("999.163.0.1");
    }
}
