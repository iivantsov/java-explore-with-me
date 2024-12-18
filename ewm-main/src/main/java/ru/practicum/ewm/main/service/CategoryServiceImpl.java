package ru.practicum.ewm.main.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.practicum.ewm.main.dto.CategoryDto;
import ru.practicum.ewm.main.dto.CategorySaveDto;
import ru.practicum.ewm.main.exception.NotFoundException;
import ru.practicum.ewm.main.mapper.CategoryMapper;
import ru.practicum.ewm.main.model.Category;
import ru.practicum.ewm.main.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepo;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto saveCategory(CategorySaveDto categorySaveDto) {
        Category category = categoryMapper.map(categorySaveDto);
        Category categorySaved = categoryRepo.save(category);
        return categoryMapper.map(categorySaved);
    }

    @Override
    public void deleteCategory(long catId) {
        Category category = categoryRepo.findById(catId).orElseThrow(() -> new NotFoundException(Category.class, catId));
        categoryRepo.delete(category);
    }

    @Override
    public CategoryDto updateCategory(long catId, CategorySaveDto categorySaveDto) {
        Category category = categoryRepo.findById(catId).orElseThrow(() -> new NotFoundException(Category.class, catId));
        category.setName(categorySaveDto.getName());
        Category categorySaved = categoryRepo.save(category);
        return categoryMapper.map(categorySaved);
    }

    @Override
    public Collection<CategoryDto> getAllCategories(int from, int size) {
        Pageable pageable = PageRequest.of(from, size);
        Collection<Category> categories = categoryRepo.findAll(pageable).toList();
        return categoryMapper.map(categories);
    }

    @Override
    public CategoryDto getCategory(long catId) {
        Category category = categoryRepo.findById(catId).orElseThrow(() -> new NotFoundException(Category.class, catId));
        return categoryMapper.map(category);
    }
}
