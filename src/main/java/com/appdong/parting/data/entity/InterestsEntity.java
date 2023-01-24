package com.appdong.parting.data.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="interests")
public class InterestsEntity {
    @Id
    private int interrestId;

    private String interestName;
    private String status;
}
