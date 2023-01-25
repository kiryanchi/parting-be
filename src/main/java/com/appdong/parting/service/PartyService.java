package com.appdong.parting.service;

import com.appdong.parting.config.BaseResponse;
import com.appdong.parting.data.dto.GetPartyDetailRes;
import com.appdong.parting.data.dto.PostOrUpdatePartyReq;

public interface PartyService {

    public GetPartyDetailRes getPartyDetail(long partyId);

    public BaseResponse deleteParty(long userId, long partyId);

    public BaseResponse updatePartyInfo(long userId, long partyId, PostOrUpdatePartyReq updatePartyReq);

    public BaseResponse postParty(PostOrUpdatePartyReq postPartyReq, long userId);
}
