package com.example.shoebe.Service.impl;

import com.example.shoebe.Service.categoryService;
import com.example.shoebe.model.category;
import com.example.shoebe.model.request.categoryRequest.addCategoryRequest;
import com.example.shoebe.model.request.categoryRequest.editCategoryRequest;
import com.example.shoebe.repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class categoryServiceImpl implements categoryService {
    @Autowired
    private categoryRepository categoryRepository;

    @Override
    public List<category> getListCategories() {
        return categoryRepository.findByIsDelete(false);
    }

    @Override
    public category addCategory(addCategoryRequest request) {
        var newCategory = new category(request.getName());
        return categoryRepository.save(newCategory);
    }

    @Override
    public category editCategory(editCategoryRequest request) {
        var optionalCategory=categoryRepository.findById(request.getId());
        if(optionalCategory.isPresent()){
            var editCategory = optionalCategory.get();
            editCategory.setName(request.getName());
            return categoryRepository.save(editCategory);
        }
        return null;
    }

    @Override
    public boolean deleteCategory(long id) {
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
