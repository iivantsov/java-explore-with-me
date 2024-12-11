package ru.practicum.ewm.client;

import ru.practicum.ewm.dto.StatDto;
import ru.practicum.ewm.dto.StatSaveDto;
import ru.practicum.ewm.util.DateTimeCoder;

import lombok.RequiredArgsConstructor;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class EwmStatServiceClient {
    private final RestClient restClient;
    private final DateTimeCoder dateTimeCoder;

    public ResponseEntity<StatDto> postHitRequest(StatSaveDto statSaveDto) {
        return restClient.post()
                .uri("/hit")
                .contentType(MediaType.APPLICATION_JSON)
                .body(statSaveDto)
                .retrieve()
                .toEntity(StatDto.class);
    }

    public ResponseEntity<Collection<StatDto>> getStatsRequest(LocalDateTime start, LocalDateTime end, String[] uris, boolean unique) {
        String startEnc = dateTimeCoder.encode(start);
        String endEnc = dateTimeCoder.encode(end);
        return restClient.get()
                .uri(uriBuilder -> uriBuilder.path("/stats")
                        .queryParam("start", startEnc)
                        .queryParam("end", endEnc)
                        .queryParam("uris", (Object[]) uris)
                        .queryParam("unique", unique)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {});
    }
}
