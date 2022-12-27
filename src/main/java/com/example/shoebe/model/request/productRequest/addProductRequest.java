package com.example.shoebe.model.request.productRequest;

import lombok.Data;

@Data
public class addProductRequest {
    private long categoryId;
    private String name;
    private String size;
    private String price;

}
