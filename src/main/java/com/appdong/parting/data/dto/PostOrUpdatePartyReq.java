package com.appdong.parting.data.dto;

import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Getter
public class PostOrUpdatePartyReq {
    private int categoryId;
    private List<Integer> categoryDetailIdList;

    private String partyName;
    private String partyStartDateTime;
    private String partyEndDateTime;

    private List<String> hashTagNameList;

    private int utmX;               // 경도
    private int utmY;               // 위도

    private String address;

    private int maxAge;
    private int minAge;

    private int capacity;

    private String partyDescription;
}
