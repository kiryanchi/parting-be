package com.appdong.parting.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class getPartyDayByMonthRes {
    java.math.BigInteger partyId;
    String partyName;
    int dday;

    String partyDate;
}
