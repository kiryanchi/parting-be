package com.appdong.parting.controller;


import com.appdong.parting.service.CategoryService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
