package ru.practicum.ewm.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.ewm.main.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
