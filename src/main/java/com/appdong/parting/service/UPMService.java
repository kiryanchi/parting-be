package com.appdong.parting.service;

import com.appdong.parting.data.dto.GetPartyMakedByMe;

import java.util.ArrayList;

public interface UPMService {

    public ArrayList<GetPartyMakedByMe> getPartiesMakedByMe(long userId);
}
