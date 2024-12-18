package ru.practicum.ewm.stat.util;

import java.time.LocalDateTime;

public interface DateTimeCoder {

    String encode(LocalDateTime dateTime);

    LocalDateTime decode(String encodedDateTime);
}
