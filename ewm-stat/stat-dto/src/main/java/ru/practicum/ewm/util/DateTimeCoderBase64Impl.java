package ru.practicum.ewm.util;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class DateTimeCoderBase64Impl implements DateTimeCoder {
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    @Override
    public String encode(LocalDateTime dateTime) {
        byte[] encodedBytes = Base64.getEncoder().encode(dateTime.toString().getBytes());
        return new String(encodedBytes, CHARSET);
    }

    @Override
    public LocalDateTime decode(String encodedDateTime) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedDateTime);
        String decodedDateTime = new String(decodedBytes, CHARSET);
        return LocalDateTime.parse(decodedDateTime);
    }
}
