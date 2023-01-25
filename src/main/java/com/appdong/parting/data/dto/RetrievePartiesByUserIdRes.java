package com.appdong.parting.data.dto;

import com.appdong.parting.data.entity.HashTagsEntity;
import com.appdong.parting.data.entity.PartyEntity;
import com.appdong.parting.data.entity.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RetrievePartiesByUserIdRes {
    long partyId;

    String partyImgUrl;
    String partyName;

    int currentPartyMemberCount;
    int maxPartyMemberCount;

    String address;
    int distance;
    String distanceUnit;

    List<String> hashTag;
    String partyTimeStr; // ex) 2022.11.11 PM 1시~3시

    public RetrievePartiesByUserIdRes(PartyEntity partyEntity) {
        List<HashTagsEntity> hashTagsEntityList=partyEntity.getHashTagsEntityList();
        List<String> hashTagNameList=new ArrayList<String>();

        for(int i=0; i<hashTagsEntityList.size(); i++){
            hashTagNameList.add(hashTagsEntityList.get(i).getHashTagName());
        }

        SimpleDateFormat partyStartTimeFormat=new SimpleDateFormat("yyyy.MM.DD.E- a. hh시");
        String startTimeFormatStr=partyStartTimeFormat.format(partyEntity.getPartyStartDateTime()).replace("오전","AM");
        startTimeFormatStr=startTimeFormatStr.replace("오후","PM");

        SimpleDateFormat partyEndTimeFormat=new SimpleDateFormat("~hh시");
        String endTimeFormatStr=partyEndTimeFormat.format(partyEntity.getPartyEndDateTime());
        String partyDateTimeStr=startTimeFormatStr+endTimeFormatStr;

        this.partyId = partyEntity.getId();
        this.partyImgUrl = partyEntity.getStoreImgUrl();
        this.partyName = partyEntity.getPartyName();
        this.currentPartyMemberCount = partyEntity.getUserpartymappingtableEntityList().size();
        this.maxPartyMemberCount = partyEntity.getCapacity();
        this.address = partyEntity.getAddress();
        this.distance = 0;
        this.distanceUnit = null;
        this.hashTag = hashTagNameList;
        this.partyTimeStr = partyDateTimeStr;
    }
}
