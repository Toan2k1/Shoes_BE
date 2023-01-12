package com.example.shoebe.Service;

import com.example.shoebe.model.ImageModel;
import com.example.shoebe.model.product;
import com.example.shoebe.model.request.addImageRequest;
import com.example.shoebe.repository.StorageRepository;
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

@Service
public class StorageService {
    @Autowired
    private StorageRepository repository;
    @Autowired
    private productRepository productRepository;
    public final String UPLOAD_DIR = "C:\\Hosting\\img";


    public List<ImageModel> getListImage() {
        return repository.findByIsDelete(false);
    }
    public ImageModel uploadImage(MultipartFile file, addImageRequest request) throws IOException {
        var ProductName=productRepository.findByName(request.getProductName());
        Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        if(ProductName.isPresent()){
            var product=ProductName.get();
            ImageModel imageModel= new ImageModel(
                    request.getProductName(),product);
            imageModel.setName(file.getOriginalFilename());
            return repository.save(imageModel);
    }
        return null;
    }
    public boolean deleteImage(long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
