package ru.practicum.ewm.main.controller.pub;

import ru.practicum.ewm.main.dto.CategoryDto;
import ru.practicum.ewm.main.service.CategoryService;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import lombok.RequiredArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/categories")
@Validated
@RequiredArgsConstructor
public class PublicCategoriesController {
    private final CategoryService categoryService;

    @GetMapping
    public Collection<CategoryDto> getAllCategories(@RequestParam(defaultValue = "0") @PositiveOrZero int from,
                                                    @RequestParam(defaultValue = "10") @Positive int size) {
        return categoryService.getAllCategories(from, size);
    }

    @GetMapping("/{catId}")
    public CategoryDto getCategory(@PathVariable long catId) {
        return categoryService.getCategory(catId);
    }
}
