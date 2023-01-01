package com.example.shoebe.model.request.productRequest;

import lombok.Data;

@Data
public class addProductRequest {
    private String categoryName;
    private String name;
    private String size;
    private String price;
    private String description;
    private String quantity;
    private String color;

}
