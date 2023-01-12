package com.example.shoebe.Controller;


import com.example.shoebe.Service.StorageService;
import com.example.shoebe.model.ImageModel;
import com.example.shoebe.model.request.addImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/images")
public class ImageController {

@Autowired
    private StorageService storageService;

@PostMapping("/addImage")
    ImageModel addImage(@ModelAttribute addImageRequest request, @RequestParam("file") MultipartFile file) throws Exception{
    return storageService.uploadImage(file,request);
}
    @DeleteMapping("/deleteImage/{id}")
    Boolean deleteProduct(@PathVariable long id){
        return  storageService.deleteImage(id);
    }
    @GetMapping("/get-list-image")
    List<ImageModel> getListProduct(){
        return storageService.getListImage();
    }
}

