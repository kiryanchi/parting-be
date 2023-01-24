package com.appdong.parting.controller;

import com.appdong.parting.config.BaseResponse;
import com.appdong.parting.data.dto.GetPartyMakedByMe;
import com.appdong.parting.data.entity.UserPartyMappingEntity;
import com.appdong.parting.service.UPMService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UPMController {
    private UPMService upmService;

    public UPMController(UPMService upmService) {
        this.upmService = upmService;
    }

    @GetMapping(value = "/api/my-party")
    public ArrayList<GetPartyMakedByMe> getPartiesMakedByMe(){

        long userId=1;

        return upmService.getPartiesMakedByMe(userId);
    }

    @PostMapping(value="/api/party/{partyId}/member")
    public BaseResponse<String> enterParty(@PathVariable("partyId") long partyId){
        long userId=3;


        return upmService.enterParty(userId,partyId);
    }
}
