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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class productController {

    @Autowired
    private productService ProductService;



    @PostMapping("/add-product")
    product addProduct(@ModelAttribute addProductRequest request, @RequestPart("file")MultipartFile file) throws Exception {
        return ProductService.addProduct(request,file);
    }
    @GetMapping("/get-list-product")
    List<product> getListProduct(){
        return ProductService.getListProduct();
    }
    @PutMapping("/edit-Product/{id}")
    product editProduct(@PathVariable long id,@RequestBody editProductRequest request){
        request.setId(id);
        return ProductService.editProduct(request);
    }
    @DeleteMapping("/deleteProduct/{id}")
    Boolean deleteProduct(@PathVariable long id){
        return  ProductService.deleteProduct(id);
    }
    @GetMapping("/getProductbyId/{id}")
    product getProductById(@PathVariable("id") long id){
        return ProductService.getProductById(id);
    }
}
