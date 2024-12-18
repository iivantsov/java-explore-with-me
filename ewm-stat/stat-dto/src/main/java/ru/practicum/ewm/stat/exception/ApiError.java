package ru.practicum.ewm.stat.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiError {
    static final DateTimeFormatter DT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ApiError(String status, String reason, String message, String error) {
        this.status = status;
        this.reason = reason;
        this.message = message;
        this.error = error;
        timestamp = DT_FORMATTER.format(LocalDateTime.now());
    }

    final String status;
    final String reason;
    final String message;
    final String error;
    final String timestamp;
}
