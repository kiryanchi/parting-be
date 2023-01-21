package com.appdong.parting.data.entity;


import javax.persistence.*;

@Entity
@Table(name="interestDetails")
public class InterestDetailsEntity {
    @Id
    private int interestDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="interesetId")
    private InterestsEntity interests;
    private String interestName;
    private String status;

}