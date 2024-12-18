package ru.practicum.ewm.main.mapper;

import org.mapstruct.Mapper;
import ru.practicum.ewm.main.dto.CategoryDto;
import ru.practicum.ewm.main.dto.CategorySaveDto;
import ru.practicum.ewm.main.model.Category;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category map(CategorySaveDto categorySaveDto);

    CategoryDto map(Category category);

    Collection<CategoryDto> map(Collection<Category> categories);
}
