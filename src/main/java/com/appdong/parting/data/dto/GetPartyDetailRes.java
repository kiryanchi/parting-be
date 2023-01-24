package com.appdong.parting.data.dto;

import com.appdong.parting.data.entity.HashTagsEntity;
import com.appdong.parting.data.entity.PartyEntity;
import com.appdong.parting.data.entity.UserPartyMappingEntity;
import com.appdong.parting.data.entity.UsersEntity;
import com.appdong.parting.data.models.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetPartyDetailRes {
    long partyId;

    String partyImgUrl;
    String partyName;

    int currentPartyMemberCount;
    int maxPartyMemberCount;

    int hostReliability;

    String deadLineDate;

    int minAge;
    int maxAge;
    String partyTimeStr; // ex) 2022.11.11 PM 1시~3시
    int utmX;
    int utmY;
    String address;
    int distance;
    String distanceUnit;


    String partyDescrpiton;

    List<Member> memberList;

    String categoryName;        // 카테고리
    String categoryDetailName;  // 세부 카테고리
    List<String> hashTag;

    String status; // 모집 완료유무를 가져온다. 모집 완료일경우 "모집 완료"만 표시되면 되고 모집중일 경우 dealine에대한 string이 표시된다.
                    // 예: 11월 11일 PM. 1:00 모집 마감


    public GetPartyDetailRes(PartyEntity partyEntity) {
        List<UserPartyMappingEntity> mappingList=partyEntity.getUserpartymappingtableEntityList();
        List<Member> tmpMemberList=new ArrayList<Member>();
        UsersEntity host = null;
        List<HashTagsEntity> hashTagsEntityList=partyEntity.getHashTagsEntityList();
        List<String> hashTagNameList=new ArrayList<String>();

        for (int i=0; i<mappingList.size(); i++){
            if(mappingList.get(i).getStatus().equals("host")){
                host=mappingList.get(i).getUsers();
            }

            tmpMemberList.add(new Member(mappingList.get(i).getUsers()));
        }
        for(int i=0; i<hashTagsEntityList.size(); i++){
            hashTagNameList.add(hashTagsEntityList.get(i).getHashtagName());
        }
        SimpleDateFormat deadLineFormat= new SimpleDateFormat("MM월DD일 a hh:mm 모집 마감");
        String deadLineFormatStr=deadLineFormat.format(partyEntity.getDeadLine()).replace("오전","AM");
        deadLineFormatStr=deadLineFormatStr.replace("오후","PM");

        SimpleDateFormat partyStartTimeFormat=new SimpleDateFormat("yyyy.MM.DD.E- a. hh시");
        String startTimeFormatStr=partyStartTimeFormat.format(partyEntity.getPartyStartDateTime()).replace("오전","AM");
        startTimeFormatStr=startTimeFormatStr.replace("오후","PM");

        SimpleDateFormat partyEndTimeFormat=new SimpleDateFormat("~hh시");
        String endTimeFormatStr=partyEndTimeFormat.format(partyEntity.getPartyEndDateTime());
        String partyDateTimeStr=startTimeFormatStr+endTimeFormatStr;

        this.partyId = partyEntity.getId();
        this.partyImgUrl = partyEntity.getStoreImgUrl();
        this.partyName = partyEntity.getPartyName();
        this.currentPartyMemberCount = tmpMemberList.size();
        this.maxPartyMemberCount = partyEntity.getCapacity();
        this.hostReliability = host.getReliability(); //Todo 확인필요
        this.deadLineDate = deadLineFormatStr;  //Todo 확인필요
        this.minAge = partyEntity.getMinAge();
        this.maxAge = partyEntity.getMaxAge();
        this.partyTimeStr = partyDateTimeStr;
        this.utmX = partyEntity.getUtmX();
        this.utmY = partyEntity.getUtmY();
        this.address = null; //Todo 확인필요
        this.distance = 0; //Todo 확인필요
        this.distanceUnit = null; //Todo 확인필요
        this.partyDescrpiton = partyEntity.getComment();
        this.memberList = tmpMemberList;
        this.categoryName = partyEntity.getCategoryDetailEntity().getCategoriesEntity().getCategoryName();
        this.categoryDetailName = partyEntity.getCategoryDetailEntity().getCategoryName();
        this.hashTag = hashTagNameList;
        this.status = partyEntity.getStatus();
    }
}
