package com.appdong.parting.data.dto;

import java.util.List;

public class getPartyListsRes {
    java.math.BigInteger partyId;

    String partyImgUrl;
    String partyName;

    int currentPartyMemberCount;
    int maxPartyMemberCount;

    String address;
    int distance;
    String distanceUnit;

    List<String> hashTag;
    String partyTimeStr; // ex) 2022.11.11 PM 1시~3시
}
