package com.example.product_category_service.endpoint;

import com.example.product_category_service.dto.CategoryResponseDto;
import com.example.product_category_service.dto.CreateCategoryDto;
import com.example.product_category_service.dto.UpdateCategoryDto;
import com.example.product_category_service.entity.Category;
import com.example.product_category_service.mapper.CategoryMapper;
import com.example.product_category_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryEndpoint {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping("/categories")
    public List<CategoryResponseDto> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) {
        Optional<Category> byId = categoryService.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }


    @PostMapping("/categories")
    public ResponseEntity<CreateCategoryDto> createCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        categoryService.save(categoryMapper.map(createCategoryDto));
        return ResponseEntity.ok(createCategoryDto);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") @RequestBody UpdateCategoryDto updateCategoryDto) {
        if (updateCategoryDto == null) {
            return ResponseEntity.badRequest().build();
        }
        categoryService.save(categoryMapper.map(updateCategoryDto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id") int id) {
        categoryService.removeById(id);
        return ResponseEntity.noContent().build();
    }
}







