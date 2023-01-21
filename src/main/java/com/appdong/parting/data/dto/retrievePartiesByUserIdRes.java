package com.appdong.parting.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class retrievePartiesByUserIdRes {
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
