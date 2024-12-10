package ru.practicum.ewm.dto;

import lombok.Data;

@Data
public class StatDto {
    String app;
    String uri;
    long hits;
}
