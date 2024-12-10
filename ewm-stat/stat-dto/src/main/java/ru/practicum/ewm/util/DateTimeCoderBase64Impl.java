package ru.practicum.ewm.util;

import java.nio.charset.Charset;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

public class DateTimeCoderBase64Impl implements DateTimeCoder {
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    @Override
    public String encode(LocalDateTime dateTime) {
        return Base64.getUrlEncoder().encodeToString(dateTime.toString().getBytes(CHARSET));
    }

    @Override
    public LocalDateTime decode(String encodedDateTime) {
        byte[] decodedDateTimeBytes = Base64.getUrlDecoder().decode(encodedDateTime);
        String decodedDateTime = new String(decodedDateTimeBytes, CHARSET);
        return LocalDateTime.parse(decodedDateTime);
    }
}
