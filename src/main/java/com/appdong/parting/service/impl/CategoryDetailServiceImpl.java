package com.appdong.parting.service.impl;

import com.appdong.parting.repository.CategoryDetailRepository;
import com.appdong.parting.service.CategoryDetailService;
import org.springframework.stereotype.Service;

@Service
public class CategoryDetailServiceImpl implements CategoryDetailService {
    CategoryDetailRepository categoryDetailRepository;

    public CategoryDetailServiceImpl(CategoryDetailRepository categoryDetailRepository) {
        this.categoryDetailRepository = categoryDetailRepository;
    }
}
