package ru.practicum.ewm.service;

import lombok.RequiredArgsConstructor;
import ru.practicum.ewm.dto.StatDto;
import ru.practicum.ewm.dto.StatSaveDto;

import ru.practicum.ewm.exception.NotValidException;
import ru.practicum.ewm.model.Stat;
import ru.practicum.ewm.repository.StatRepository;
import ru.practicum.ewm.util.DateTimeCoder;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatServiceImpl implements StatService {
    private final StatRepository statRepo;
    private final StatMapper statMapper;
    private final DateTimeCoder dateTimeCoder;

    @Override
    public StatDto saveStat(StatSaveDto statSaveDto) {
        Stat stat = statMapper.map(statSaveDto);
        Stat statSaved = statRepo.save(stat);
        return statMapper.map(statSaved);
    }

    @Override
    public Collection<StatDto> getStat(String start, String end, String[] uris, boolean unique) {
        LocalDateTime startDec = dateTimeCoder.decode(start);
        LocalDateTime endDec = dateTimeCoder.decode(end);

        if (startDec.isAfter(endDec)) {
            throw new NotValidException(LocalDateTime.class, "start is after end");
        } else if (startDec.isEqual(endDec)) {
            return List.of();
        }

        return (uris == null || uris.length == 0) ?
                statRepo.getStats(startDec, endDec, unique) :
                statRepo.getStats(startDec, endDec, unique, List.of(uris));
    }
}
