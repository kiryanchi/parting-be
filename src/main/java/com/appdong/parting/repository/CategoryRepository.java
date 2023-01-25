package com.appdong.parting.repository;

import com.appdong.parting.data.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoriesEntity,Integer> {
}
