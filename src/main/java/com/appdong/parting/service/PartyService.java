package com.appdong.parting.service;

import com.appdong.parting.config.BaseResponse;
import com.appdong.parting.data.dto.GetPartyDetailRes;

public interface PartyService {

    public GetPartyDetailRes getPartyDetail(long partyId);

    public BaseResponse deleteParty(long userId, long partyId);
}
