package com.example.product_category_service.endpoint;

import com.example.product_category_service.dto.CreateProductDto;
import com.example.product_category_service.dto.ProductResponseDto;
import com.example.product_category_service.dto.UpdateProductDto;
import com.example.product_category_service.entity.Product;
import com.example.product_category_service.mapper.ProductMapper;
import com.example.product_category_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductEndpoint {

    private final ProductService productService;
    private final ProductMapper productMapper;


    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        Optional<Product> byId = productService.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }


    @PostMapping("/products")
    public ResponseEntity<CreateProductDto> createProduct(@RequestBody CreateProductDto createProductDto) {
        productService.save(productMapper.map(createProductDto));
        return ResponseEntity.ok(createProductDto);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") @RequestBody UpdateProductDto updateProductDto) {
        if (updateProductDto == null) {
            return ResponseEntity.badRequest().build();
        }
        productService.save(productMapper.map(updateProductDto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") int id) {
        productService.removeById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/products/byCategory/{id}")
    public ResponseEntity<?> getProductsByCategoryId(@PathVariable("id") int id) {
        List<Product> productsByCategoryId = productService.getProductsByCategoryId(id);
        return ResponseEntity.ok(productsByCategoryId);
    }

}


