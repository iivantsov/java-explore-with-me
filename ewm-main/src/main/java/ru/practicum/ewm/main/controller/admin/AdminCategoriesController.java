package ru.practicum.ewm.main.controller.admin;

import ru.practicum.ewm.main.dto.CategoryDto;
import ru.practicum.ewm.main.dto.CategorySaveDto;
import ru.practicum.ewm.main.service.CategoryService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class AdminCategoriesController {
    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDto saveCategory(@RequestBody @Valid CategorySaveDto categorySaveDto) {
        return categoryService.saveCategory(categorySaveDto);
    }

    @DeleteMapping("/{catId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable long catId) {
        categoryService.deleteCategory(catId);
    }

    @PatchMapping("/{catId}")
    public CategoryDto updateCategory(@PathVariable long catId, @RequestBody @Valid CategorySaveDto categorySaveDto) {
        return categoryService.updateCategory(catId, categorySaveDto);
    }
}
