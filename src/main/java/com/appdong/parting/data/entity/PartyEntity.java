package com.appdong.parting.data.entity;

import com.appdong.parting.data.dto.PostOrUpdatePartyReq;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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



    private String partyName;
    private int capacity;
    private Timestamp partyStartDateTime;
    private Timestamp partyEndDateTime;
    private int utmX;               // 경도
    private int utmY;              // 위도

    private String address;
    private String storeName;
    private String storeImgUrl;     // 가게 사진

    private String comment;
    private int minAge;
    private int maxAge;


    private Timestamp createdAt;
    private Timestamp updatedAt;

    private String status;     // RECRUIT,RECRUITMENT_COMPLETE, ONGOING, COMPLETE,  INACTIVE

    @OneToMany(mappedBy = "party")
    private List<UserPartyMappingEntity> userpartymappingtableEntityList;

    @OneToMany(mappedBy = "party")
    private List<HashTagsEntity> hashTagsEntityList;

    @OneToMany(mappedBy = "party")
    private List<PartyCategoryDetailMappingEntity> partyCategoryDetailMappingEntities;

    public PartyEntity(PostOrUpdatePartyReq postPartyReq) {
        this.partyName=postPartyReq.getPartyName();
        this.partyStartDateTime=java.sql.Timestamp.valueOf(postPartyReq.getPartyStartDateTime());
        this.partyEndDateTime=java.sql.Timestamp.valueOf(postPartyReq.getPartyEndDateTime());
        this.maxAge=postPartyReq.getMaxAge();
        this.minAge=postPartyReq.getMinAge();
        this.capacity=postPartyReq.getCapacity();
        this.comment=postPartyReq.getPartyDescription();
        this.utmX=postPartyReq.getUtmX();
        this.utmY=postPartyReq.getUtmY();
        this.address=postPartyReq.getAddress();
        this.status="RECRUIT";
    }


    public void update(PostOrUpdatePartyReq updatePartyReq) {
        this.partyName=updatePartyReq.getPartyName();
        this.partyStartDateTime= java.sql.Timestamp.valueOf(updatePartyReq.getPartyEndDateTime());
        this.partyEndDateTime= java.sql.Timestamp.valueOf(updatePartyReq.getPartyEndDateTime());
        this.maxAge=updatePartyReq.getMaxAge();
        this.minAge=updatePartyReq.getMinAge();
        this.comment=updatePartyReq.getPartyDescription();
        this.utmX=updatePartyReq.getUtmX();
        this.utmY=updatePartyReq.getUtmY();
        this.address=updatePartyReq.getAddress();
    }
}