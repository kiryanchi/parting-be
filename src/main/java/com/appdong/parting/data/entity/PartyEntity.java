package com.appdong.parting.data.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name="parties")
public class PartyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoryDetailId")
    private CategoriesDetailEntity categoryDetailEntity;


    private String partyName;
    private int capacity;
    private String issecret;
    private Timestamp partyStartDateTime;
    private Timestamp partyEndDateTime;
    private int utmX;               // 경도
    private int utmY;               // 위도

    private String address;
    private String storeName;
    private String storeImgUrl;     // 가게 사진

    private String comment;
    private int minAge;
    private int maxAge;

    private Timestamp deadLine;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private String status;     // RECRUIT,RECRUITMENT_COMPLETE, ONGOING, COMPLETE,  INACTIVE

    @OneToMany(mappedBy = "party")
    private List<UserPartyMappingEntity> userpartymappingtableEntityList;

    @OneToMany(mappedBy = "party")
    private List<HashTagsEntity> hashTagsEntityList;


}