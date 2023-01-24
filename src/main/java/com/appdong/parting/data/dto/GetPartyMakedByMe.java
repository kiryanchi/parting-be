package com.appdong.parting.data.dto;

import com.appdong.parting.data.entity.HashTagsEntity;
import com.appdong.parting.data.entity.PartyEntity;
import com.appdong.parting.data.entity.UsersEntity;
import lombok.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetPartyMakedByMe {
    // 실제 res가 될때는 List<getMyPartyRes>형태로 반환된다.
    private long partyId; //DB에서 BigInt형태로 저장될 예정이므로 여기서도 BigInteger를 이용해 구현된다.

    private String partyName;

    private String address;
    private int distance;
    private String distanceUnit;

    private int currentPartyMemberCount;
    private int maxPartyMemberCount;

    private String partyImgUrl;
    private String partyTime;
    private List<String> hashTag;

    private String status;

    public GetPartyMakedByMe(PartyEntity partyEntity) {
        SimpleDateFormat partyStartTimeFormat=new SimpleDateFormat("yyyy.MM.DD.E- a. hh시");
        String startTimeFormatStr=partyStartTimeFormat.format(partyEntity.getPartyStartDateTime()).replace("오전","AM");
        startTimeFormatStr=startTimeFormatStr.replace("오후","PM");

        SimpleDateFormat partyEndTimeFormat=new SimpleDateFormat("~hh시");
        String endTimeFormatStr=partyEndTimeFormat.format(partyEntity.getPartyEndDateTime());
        String partyDateTimeStr=startTimeFormatStr+endTimeFormatStr;

        List<HashTagsEntity> hashTagsEntityList=partyEntity.getHashTagsEntityList();
        List<String> hashTagNameList=new ArrayList<String>();

        for(int i=0; i<hashTagsEntityList.size(); i++){
            hashTagNameList.add(hashTagsEntityList.get(i).getHashtagName());
        }

        this.partyId = partyEntity.getId();
        this.partyName = partyEntity.getPartyName();
        this.address = partyEntity.getAddress();
        this.distance = 0;
        this.distanceUnit = null;
        this.currentPartyMemberCount = partyEntity.getUserpartymappingtableEntityList().size();
        this.maxPartyMemberCount = partyEntity.getCapacity();
        this.partyImgUrl = partyEntity.getStoreImgUrl();
        this.partyTime = partyDateTimeStr;
        this.hashTag = hashTagNameList;
        this.status = partyEntity.getStatus();
    }
}