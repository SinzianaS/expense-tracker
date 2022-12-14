package com.expensetracker.app.service;

import com.expensetracker.app.model.Category;
import com.expensetracker.app.model.Expense;
import com.expensetracker.app.repository.CategoryRepository;
import com.expensetracker.app.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
@Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll()
                          .forEach(categories::add);
        return categories;
    }

    public Category getCategory(Integer id) {
        return categoryRepository.findById(id).get();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id, Category category) {
        categoryRepository.save(category);
    }
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
