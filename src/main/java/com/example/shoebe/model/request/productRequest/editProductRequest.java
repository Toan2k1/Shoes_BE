package com.example.shoebe.model.request.productRequest;

import lombok.Data;

@Data
public class editProductRequest {
    private Long id;
    private String name;
    private String categoryName;
    private String size;
    private double price;
    private String description;
    private int quantity;
    private String color;
}
