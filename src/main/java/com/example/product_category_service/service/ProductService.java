package com.example.product_category_service.service;

import com.example.product_category_service.dto.ProductResponseDto;
import com.example.product_category_service.entity.Product;
import com.example.product_category_service.mapper.ProductMapper;
import com.example.product_category_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public void save(Product product) {

        productRepository.save(product);
    }

    public List<ProductResponseDto> getAllProducts() {

        return productMapper.map(productRepository.findAll());
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    public void removeById(int id) {

        productRepository.deleteById(id);
    }

    public List<Product> getProductsByCategoryId(int categoryId) {
        List<Product> productList = productRepository.findAllProductsByCategoryId(categoryId);
        if(productList.isEmpty()) {
            return null;
        }
        return productList;
    }


}

