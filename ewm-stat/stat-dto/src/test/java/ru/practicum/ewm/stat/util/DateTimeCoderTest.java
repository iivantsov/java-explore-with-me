package ru.practicum.ewm.stat.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.practicum.ewm.stat.util.DateTimeCoder;
import ru.practicum.ewm.stat.util.DateTimeCoderBase64Impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeCoderTest {
    private static final DateTimeFormatter DT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final DateTimeCoder dtCoder = new DateTimeCoderBase64Impl();

    @Test
    public void testEncodingThenDecodingEqualsGivenLocalDateTimeInstance() {
        // Given
        LocalDateTime formattedDateTime = LocalDateTime.parse(LocalDateTime.now().format(DT_FORMATTER), DT_FORMATTER);
        // When
        String encodedDateTime = dtCoder.encode(formattedDateTime);
        LocalDateTime decodedDatTime = dtCoder.decode(encodedDateTime);
        // Then
        Assertions.assertEquals(decodedDatTime, formattedDateTime);
    }
}
