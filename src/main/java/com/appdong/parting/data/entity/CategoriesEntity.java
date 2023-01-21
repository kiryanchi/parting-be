package com.appdong.parting.data.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Getter
@Table(name="categories")
public class CategoriesEntity {
    @Id
    private int categoryId;

    private String categoryName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String status;
}
