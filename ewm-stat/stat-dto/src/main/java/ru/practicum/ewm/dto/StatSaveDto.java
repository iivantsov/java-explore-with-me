package ru.practicum.ewm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.practicum.ewm.validation.IpAddress;

import java.time.LocalDateTime;

@Data
public class StatSaveDto {
    @NotBlank
    String app;

    @NotBlank
    String uri;

    @IpAddress(type = IpAddress.Type.V4)
    String ip;

     @NotNull
    LocalDateTime timestamp;
}
