package com.example.product_category_service.service;

import com.example.product_category_service.dto.CategoryResponseDto;
import com.example.product_category_service.entity.Category;
import com.example.product_category_service.mapper.CategoryMapper;
import com.example.product_category_service.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public List<CategoryResponseDto> getAll() {
        return categoryMapper.map(categoryRepository.findAll());
    }

    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    public void removeById(int id) {
        categoryRepository.deleteById(id);
    }
}
