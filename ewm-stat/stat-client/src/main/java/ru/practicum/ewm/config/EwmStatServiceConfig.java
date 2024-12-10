package ru.practicum.ewm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import ru.practicum.ewm.util.DateTimeCoder;
import ru.practicum.ewm.util.DateTimeCoderBase64Impl;

@Configuration
public class EwmStatServiceConfig {

    @Bean
    public RestClient restClient(@Value("${ewm-stat-service.url}") String statServiceUrl) {
        return RestClient.create(statServiceUrl);
    }

    @Bean
    public DateTimeCoder dateTimeCoder() {
        return new DateTimeCoderBase64Impl();
    }
}
