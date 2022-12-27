package com.example.shoebe.Service;



import com.example.shoebe.model.product;
import com.example.shoebe.model.request.productRequest.addProductRequest;
import com.example.shoebe.model.request.productRequest.editProductRequest;

import java.util.List;

public interface productService {
    List<product> getListProduct();
    product addProduct(addProductRequest request);
    product editProduct(editProductRequest request);
    boolean deleteProduct(long id);
}
