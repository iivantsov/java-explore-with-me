package ru.practicum.ewm.main.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CategorySaveDto {
    @NotBlank
    @Size(min = 1, max = 50)
    String name;
}
