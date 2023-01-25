package com.appdong.parting.data.entity;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Table(name="categoriesDetail")
public class CategoriesDetailEntity {
    @Id
    private int categoryDetailId;
    private String categoryName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoryId")
    private CategoriesEntity categoriesEntity;

}
