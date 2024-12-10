package ru.practicum.ewm.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.dto.StatDto;
import ru.practicum.ewm.dto.StatSaveDto;
import ru.practicum.ewm.exception.NotValidException;
import ru.practicum.ewm.service.StatService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EwmStatServiceController {
    private final StatService statService;

    @PostMapping("/hit")
    StatDto saveStat(@RequestBody StatSaveDto statSaveDto) {
        return statService.saveStat(statSaveDto);
    }

    @GetMapping("/stats")
    Collection<StatDto> getStat(@RequestParam String start,
                                @RequestParam String end,
                                @RequestParam(required = false) String[] uris,
                                @RequestParam(defaultValue = "false") boolean unique) {
        return statService.getStat(start, end, uris, unique);
    }
}
