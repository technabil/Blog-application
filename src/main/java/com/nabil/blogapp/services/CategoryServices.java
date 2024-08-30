package com.nabil.blogapp.services;

import com.nabil.blogapp.payloads.CategoryDto;

import java.util.List;

public interface CategoryServices {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer id);
    void deleteCategory(Integer id);
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Integer id);
}
