package com.example.product_category_service.dto;

import com.example.product_category_service.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductDto {

    private int id;
    private String title;
    private double price;
    private Category category;
}
