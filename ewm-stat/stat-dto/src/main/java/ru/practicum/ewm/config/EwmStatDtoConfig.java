package ru.practicum.ewm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.practicum.ewm.util.DateTimeCoder;
import ru.practicum.ewm.util.DateTimeCoderBase64Impl;
import ru.practicum.ewm.util.DateTimeCoderIdleImpl;

@Configuration
public class EwmStatDtoConfig {

    @Bean
    public DateTimeCoder dateTimeCoder(@Value("${date-time-encode}") boolean encode) {
        return encode ? new DateTimeCoderBase64Impl() : new DateTimeCoderIdleImpl();
    }
}
