package com.example.shoebe.Service;



import com.example.shoebe.model.product;
import com.example.shoebe.model.request.productRequest.addProductRequest;
import com.example.shoebe.model.request.productRequest.editProductRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface productService {
    List<product> getListProduct();
    product addProduct(addProductRequest request, MultipartFile file) throws IOException;
    product editProduct(editProductRequest request);
    boolean deleteProduct(long id);
    product getProductById(long id);
}
