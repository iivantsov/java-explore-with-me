package ru.practicum.ewm.service;

import ru.practicum.ewm.dto.StatDto;
import ru.practicum.ewm.dto.StatSaveDto;

import org.springframework.stereotype.Service;
import ru.practicum.ewm.exception.NotValidException;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
public class StatServiceImpl implements StatService {

    @Override
    public StatDto saveStat(StatSaveDto statSaveDto) {
        return null;
    }

    @Override
    public Collection<StatDto> getStat(String start, String end, String[] uris, boolean unique) {
        return List.of();
    }
}
