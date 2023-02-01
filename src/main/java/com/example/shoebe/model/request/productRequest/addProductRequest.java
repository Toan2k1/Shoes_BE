package com.example.shoebe.model.request.productRequest;

import lombok.Data;

@Data
public class addProductRequest {
    private String categoryName;
    private String name;
    private String size;
    private double price;
    private String description;
    private int quantity;
    private String color;
    private String avatar;

}
