package ru.practicum.ewm.controller;

import ru.practicum.ewm.dto.StatDto;
import ru.practicum.ewm.dto.StatSaveDto;
import ru.practicum.ewm.service.StatService;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class EwmStatServiceController {
    private final StatService statService;

    @PostMapping("/hit")
    public StatDto saveStat(@RequestBody StatSaveDto statSaveDto) {
        return statService.saveStat(statSaveDto);
    }

    @GetMapping("/stats")
    public Collection<StatDto> getStat(@RequestParam String start,
                                @RequestParam String end,
                                @RequestParam(required = false) String[] uris,
                                @RequestParam(defaultValue = "false") boolean unique) {
        return statService.getStat(start, end, uris, unique);
    }
}
