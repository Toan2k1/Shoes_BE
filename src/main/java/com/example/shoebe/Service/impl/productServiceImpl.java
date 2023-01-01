package com.example.shoebe.Service.impl;

import com.example.shoebe.Service.productService;
import com.example.shoebe.model.product;
import com.example.shoebe.model.request.productRequest.addProductRequest;
import com.example.shoebe.model.request.productRequest.editProductRequest;
import com.example.shoebe.repository.categoryRepository;
import com.example.shoebe.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productServiceImpl implements productService {
    @Autowired
   public productRepository productRepository;
    @Autowired
    public categoryRepository categoryRepository;

    @Override
    public List<product> getListProduct() {
        return productRepository.findByIsDelete(false);
    }

    @Override
    public product addProduct(addProductRequest request) {
        var categoryOptional=categoryRepository.findByName(request.getCategoryName());
        if(categoryOptional.isPresent()){
            var category = categoryOptional.get();
            var newProduct = new product(request.getName(), request.getCategoryName(), request.getSize(),request.getPrice(),request.getColor(),request.getDescription(),request.getQuantity(),category);
            return productRepository.save(newProduct);
        }
       return null;
    }

    @Override
    public product editProduct(editProductRequest request) {
        var optionalProduct=productRepository.findById(request.getId());
        if(optionalProduct.isPresent()){
            var editProduct = optionalProduct.get();
            editProduct.setName(request.getName());
            editProduct.setCategoryName(request.getCategoryName());
            editProduct.setPrice(request.getPrice());
            editProduct.setSize(request.getSize());
            editProduct.setDescription(request.getDescription());
            editProduct.setColor(request.getColor());
            editProduct.setQuantity(request.getQuantity());
            return productRepository.save(editProduct);
        }
        return null;
    }

    @Override
    public boolean deleteProduct(long id) {
        if(productRepository.existsById(id)){
           productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
