package com.appdong.parting.service;

import com.appdong.parting.config.BaseResponse;
import com.appdong.parting.config.BaseResponseStatus;
import com.appdong.parting.data.dto.GetPartyMakedByMe;
import com.appdong.parting.data.entity.UserPartyMappingEntity;

import java.util.ArrayList;

public interface UPMService {

    public BaseResponse<ArrayList<GetPartyMakedByMe>> getPartiesMakedByMe(long userId);

    public BaseResponse<String> enterParty(long userId, long partyId);
}
