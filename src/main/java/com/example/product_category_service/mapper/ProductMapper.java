package com.example.product_category_service.mapper;

import com.example.product_category_service.dto.CreateProductDto;
import com.example.product_category_service.dto.ProductResponseDto;
import com.example.product_category_service.dto.UpdateProductDto;
import com.example.product_category_service.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product map(CreateProductDto createProductDto);

    Product map(UpdateProductDto updateProductDto);

    ProductResponseDto map(Product product);

    List<ProductResponseDto> map(List<Product> productList);


}
