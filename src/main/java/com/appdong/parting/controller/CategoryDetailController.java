package com.appdong.parting.controller;

import com.appdong.parting.service.CategoryDetailService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryDetailController {
    CategoryDetailService categoryDetailService;

    public CategoryDetailController(CategoryDetailService categoryDetailService) {
        this.categoryDetailService = categoryDetailService;
    }
}
