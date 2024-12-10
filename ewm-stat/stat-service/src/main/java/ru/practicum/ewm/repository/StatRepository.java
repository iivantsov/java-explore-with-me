package ru.practicum.ewm.repository;

import ru.practicum.ewm.dto.StatDto;
import ru.practicum.ewm.model.Stat;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface StatRepository extends JpaRepository<Stat, Long> {

    @Query("""
            SELECT new ru.practicum.ewm.dto.StatDto(s.app, s.uri,
              (CASE WHEN :unique = true THEN COUNT(DISTINCT s.ip) ELSE COUNT(s.ip) END))
            FROM Stat AS s
            WHERE s.timestamp BETWEEN :start AND :end
            GROUP BY s.app,
                     s.uri
            ORDER BY COUNT(s.ip) DESC
           """)
    Collection<StatDto> getStats(LocalDateTime start, LocalDateTime end, boolean unique);

    @Query("""
            SELECT new ru.practicum.ewm.dto.StatDto(s.app, s.uri,
              (CASE WHEN :unique = true THEN COUNT(DISTINCT s.ip) ELSE COUNT(s.ip) END))
            FROM Stat AS s
            WHERE s.timestamp BETWEEN :start AND :end
              AND s.uri IN :uris
            GROUP BY s.app,
                     s.uri
            ORDER BY COUNT(s.ip) DESC
           """)
    Collection<StatDto> getStats(LocalDateTime start, LocalDateTime end, boolean unique, List<String> uris);
}
