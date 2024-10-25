package com.francopaiz.financialManagementAPI.service.category;


import com.francopaiz.financialManagementAPI.model.Category;
import com.francopaiz.financialManagementAPI.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getCategories() {
        return categoryRepository.getCategories();
    }

    @Override
    public Category findCategoryById(String id) {
        return categoryRepository.findCategoryById(id).orElse(null);
    }

    @Override
    public Category createCategory(Category category) {

        return categoryRepository.createCategory(category);
    }

    @Override
    public Category updateCategory(String id, Category category) {

        Category existingCategory =  categoryRepository.findCategoryById(id).orElseThrow(()-> new IllegalArgumentException("Categoría no encontrada"));

        if (category.getName() != null){
            existingCategory.setName(category.getName());
        }

        return categoryRepository.updateCategory(existingCategory);
    }

    @Override
    public void deleteCategory(String id) {
        categoryRepository.deleteCategory(id);
    }
}
