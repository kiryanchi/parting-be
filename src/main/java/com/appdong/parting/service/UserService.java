package com.appdong.parting.service;

import com.appdong.parting.data.dto.GetPartyDdayRes;
import com.appdong.parting.data.dto.GetPartyMakedByMe;
import com.appdong.parting.data.dto.RetrievePartiesByUserIdRes;

import java.util.ArrayList;

public interface UserService {
    public GetPartyDdayRes getPartyDdayByUserId(long userId);
    public ArrayList<RetrievePartiesByUserIdRes> getEnteredParties(long userId);



}
