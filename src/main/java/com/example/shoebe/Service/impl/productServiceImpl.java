package com.example.shoebe.Service.impl;

import com.example.shoebe.Service.productService;
import com.example.shoebe.model.product;
import com.example.shoebe.model.request.productRequest.addProductRequest;
import com.example.shoebe.model.request.productRequest.editProductRequest;
import com.example.shoebe.repository.categoryRepository;
import com.example.shoebe.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class productServiceImpl implements productService {
    @Autowired
   public productRepository productRepository;
    @Autowired
    public categoryRepository categoryRepository;
    public final String UPLOAD_DIR = "C:\\Hosting\\img";

    @Override
    public List<product> getListProduct() {
        return productRepository.findByIsDelete(false);
    }

    @Override
    public product addProduct(addProductRequest request, MultipartFile file) throws IOException {
        Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        var categoryOptional=categoryRepository.findByName(request.getCategoryName());
        if(categoryOptional.isPresent()){
            var category = categoryOptional.get();
            product newProduct =new product(
                    request.getCategoryName(),
                    request.getName(),
                    request.getColor(),
                    request.getSize(),
                    request.getPrice(),
                    request.getDescription(),
                    request.getAvatar(),
                    request.getQuantity(),category
            );
            newProduct.setAvatar(file.getOriginalFilename());
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

    @Override
    public product getProductById(long id) {
        Optional<product> product1=productRepository.findById(id);
        if(product1.isPresent()) {
            return productRepository.getById(id);
        }

        return null;
    }
}
