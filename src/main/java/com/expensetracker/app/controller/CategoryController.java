package com.expensetracker.app.controller;

import com.expensetracker.app.model.Category;
import com.expensetracker.app.model.Expense;
import com.expensetracker.app.repository.CategoryRepository;
import com.expensetracker.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categories")
    Collection<Category> categories(){
        //return categoryRepository.findAll();        //select all from category table
        return categoryService.getAllCategories();
    }

    @RequestMapping("categories/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        return categoryService.getCategory(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/categories")
        public void addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/categories/{id}")
        public void updateCategory(@RequestBody Category category, @PathVariable Integer id) {
        categoryService.updateCategory(id, category);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/categories/{id}")
        public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
