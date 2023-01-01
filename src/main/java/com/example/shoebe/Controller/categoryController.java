package com.example.shoebe.Controller;

import com.example.shoebe.Service.categoryService;
import com.example.shoebe.model.category;
import com.example.shoebe.model.request.categoryRequest.addCategoryRequest;
import com.example.shoebe.model.request.categoryRequest.editCategoryRequest;
import com.example.shoebe.repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class categoryController {
    @Autowired
    private categoryRepository categoryRepository;
    @Autowired
    private categoryService categoryService;


    @PostMapping("/add-category")
    category addCategory(@RequestBody addCategoryRequest request) {
        return categoryService.addCategory(request);
    }
    @GetMapping("/get-list-category")
    List<category> getListCategories(){
        return categoryService.getListCategories();
    }
    @PutMapping("/editCategory/{id}")
    category editCategory(@PathVariable long id,@RequestBody editCategoryRequest request){
        request.setId(id);
        return categoryService.editCategory(request);
    }
    @DeleteMapping("/deleteCategory/{id}")
    Boolean deleteCategory(@PathVariable long id){
        return  categoryService.deleteCategory(id);
    }
}
