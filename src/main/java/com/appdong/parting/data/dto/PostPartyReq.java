package com.appdong.parting.data.dto;

import java.util.List;

public class PostPartyReq {

    int categoryId;
    int categoryDetailId;

    String partyName;
    List<String> HashTag;
    String Date;
    String Time;

    String location; //Todo 위치정보 어떻게 저장할 지 못정함.

    int maxAge;
    int minAge;
    String partyDescription;
}
