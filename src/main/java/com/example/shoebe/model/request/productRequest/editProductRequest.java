package com.example.shoebe.model.request.productRequest;

import lombok.Data;

@Data
public class editProductRequest {
    private Long id;
    private String name;
    private String image;
    private String size;
    private String price;
    private String description;
    private String quantity;
    private String color;
}
