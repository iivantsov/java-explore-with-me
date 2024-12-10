package ru.practicum.ewm.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class DateTimeCoderTest {
    private final DateTimeCoder coder = new DateTimeCoderBase64Impl();

    @Test
    public void testEncodingThenDecodingEqualsGivenLocalDateTimeInstance() {
        // Given
        LocalDateTime dateTime = LocalDateTime.now();
        // When
        String encodedDateTime = coder.encode(dateTime);
        LocalDateTime decodedDatTime = coder.decode(encodedDateTime);
        // Then
        Assertions.assertEquals(decodedDatTime, dateTime);
    }
}
