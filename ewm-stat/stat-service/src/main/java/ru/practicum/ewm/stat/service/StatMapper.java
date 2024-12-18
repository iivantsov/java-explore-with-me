package ru.practicum.ewm.stat.service;

import org.mapstruct.Mapper;
import ru.practicum.ewm.stat.dto.StatDto;
import ru.practicum.ewm.stat.dto.StatSaveDto;
import ru.practicum.ewm.stat.model.Stat;

@Mapper(componentModel = "spring")
public interface StatMapper {

    Stat map(StatSaveDto statSaveDto);

    StatDto map(Stat stat);
}
