package ru.practicum.ewm.service;

import ru.practicum.ewm.dto.StatDto;
import ru.practicum.ewm.dto.StatSaveDto;

import java.time.LocalDateTime;
import java.util.Collection;

public interface StatService {

    StatDto saveStat(StatSaveDto statSaveDto);

    Collection<StatDto> getStat(String start, String end, String[] uris, boolean unique);
}
