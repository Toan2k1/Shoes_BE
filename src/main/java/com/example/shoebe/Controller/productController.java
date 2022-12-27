package com.example.shoebe.Controller;

import com.example.shoebe.Service.categoryService;
import com.example.shoebe.Service.productService;
import com.example.shoebe.model.category;
import com.example.shoebe.model.product;
import com.example.shoebe.model.request.categoryRequest.addCategoryRequest;
import com.example.shoebe.model.request.categoryRequest.editCategoryRequest;
import com.example.shoebe.model.request.productRequest.addProductRequest;
import com.example.shoebe.model.request.productRequest.editProductRequest;
import com.example.shoebe.repository.categoryRepository;
import com.example.shoebe.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class productController {

    @Autowired
    private productService ProductService;



    @PostMapping("/add-product")
    product addProduct(@RequestBody addProductRequest request) {
        return ProductService.addProduct(request);
    }
    @GetMapping("/get-list-product")
    List<product> getListProduct(){
        return ProductService.getListProduct();
    }
    @PutMapping("/edit-Product")
    product editProduct(@RequestBody editProductRequest request){
        return ProductService.editProduct(request);
    }
    @DeleteMapping("/deleteProduct/{id}")
    Boolean deleteProduct(@PathVariable long id){
        return  ProductService.deleteProduct(id);
    }
}
