package ru.practicum.ewm.repository;

import ru.practicum.ewm.model.Stat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stat, Long> {
}
