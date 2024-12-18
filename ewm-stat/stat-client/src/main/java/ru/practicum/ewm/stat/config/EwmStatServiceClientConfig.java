package ru.practicum.ewm.stat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class EwmStatServiceClientConfig {

    @Bean
    public RestClient restClient(@Value("${ewm-stat-service.url}") String statServiceUrl) {
        return RestClient.create(statServiceUrl);
    }
}
