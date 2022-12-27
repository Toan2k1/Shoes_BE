package com.example.shoebe.Service;

import com.example.shoebe.model.category;
import com.example.shoebe.model.request.categoryRequest.addCategoryRequest;
import com.example.shoebe.model.request.categoryRequest.editCategoryRequest;

import java.util.List;

public interface categoryService {
    List<category> getListCategories();
    category addCategory(addCategoryRequest request);
    category editCategory(editCategoryRequest request);
    boolean deleteCategory(long id);
}
