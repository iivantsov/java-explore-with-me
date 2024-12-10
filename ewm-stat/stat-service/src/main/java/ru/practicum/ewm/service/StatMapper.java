package ru.practicum.ewm.service;

import org.mapstruct.Mapper;
import ru.practicum.ewm.dto.StatDto;
import ru.practicum.ewm.dto.StatSaveDto;
import ru.practicum.ewm.model.Stat;

@Mapper(componentModel = "spring")
public interface StatMapper {

    Stat map(StatSaveDto statSaveDto);

    StatDto map(Stat stat);
}
