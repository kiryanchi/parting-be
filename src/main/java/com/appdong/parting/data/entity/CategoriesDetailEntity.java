package com.appdong.parting.data.entity;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Table(name="categoriesDetail")
public class CategoriesDetailEntity {
    @Id
    private int categoryDetailId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoryId")
    private CategoriesEntity categoriesEntity;
    private String categoryName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String status;
}
