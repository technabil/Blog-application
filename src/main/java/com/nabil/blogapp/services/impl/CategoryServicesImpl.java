package com.nabil.blogapp.services.impl;

import com.nabil.blogapp.exceptions.ResourceNotFoundException;
import com.nabil.blogapp.model.Category;
import com.nabil.blogapp.payloads.CategoryDto;
import com.nabil.blogapp.reposatories.CategoryRepo;
import com.nabil.blogapp.services.CategoryServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServicesImpl implements CategoryServices {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        category = this.categoryRepo.save(category);
        return this.modelMapper.map(category, CategoryDto.class);
    }
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
        Category category = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",id));
        category.setCategoryName(categoryDto.getCategoryName());
        category.setCategoryDesc(categoryDto.getCategoryDesc());
        category = this.categoryRepo.save(category);
        return this.modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",id));
        this.categoryRepo.delete(category);

    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> list = categories.stream().map(category -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
        return list;
    }
    @Override
    public CategoryDto getCategoryById(Integer id) {
        Category category = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",id));
        return this.modelMapper.map(category, CategoryDto.class);
    }
}
