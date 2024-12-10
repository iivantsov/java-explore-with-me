package ru.practicum.ewm.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeCoderIdleImpl implements DateTimeCoder {
    private static final DateTimeFormatter DT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String encode(LocalDateTime dateTime) {
        return dateTime.format(DT_FORMATTER);
    }

    @Override
    public LocalDateTime decode(String encodedDateTime) {
        return LocalDateTime.parse(encodedDateTime, DT_FORMATTER);
    }
}