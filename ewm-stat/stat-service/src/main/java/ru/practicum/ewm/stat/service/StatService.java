package ru.practicum.ewm.stat.service;

import ru.practicum.ewm.stat.dto.StatDto;
import ru.practicum.ewm.stat.dto.StatSaveDto;

import java.util.Collection;

public interface StatService {

    StatDto saveStat(StatSaveDto statSaveDto);

    Collection<StatDto> getStat(String start, String end, String[] uris, boolean unique);
}
