package com.appdong.parting.service;

import com.appdong.parting.data.dto.GetPartyDdayRes;
import com.appdong.parting.data.dto.GetPartyMakedByMe;

public interface UserService {
    public GetPartyDdayRes getPartyDdayByUserId(long userId);
}
