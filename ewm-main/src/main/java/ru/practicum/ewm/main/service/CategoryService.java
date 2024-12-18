package ru.practicum.ewm.main.service;

import ru.practicum.ewm.main.dto.CategoryDto;
import ru.practicum.ewm.main.dto.CategorySaveDto;

import java.util.Collection;

public interface CategoryService {

    CategoryDto saveCategory(CategorySaveDto categorySaveDto);

    void deleteCategory(long catId);

    CategoryDto updateCategory(long catId, CategorySaveDto categorySaveDto);

    Collection<CategoryDto> getAllCategories(int from, int size);

    CategoryDto getCategory(long catId);
}
