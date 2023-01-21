package com.appdong.parting.controller;

import com.appdong.parting.data.dto.GetPartyDetailRes;
import com.appdong.parting.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PartyController {

    private PartyService partyService;

    @Autowired
    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    //DTO 설계 완( Req dto는 필요 x header에서 token받아서 userId뽑아내기만 하면 됨. Res는 설계 완)
    @GetMapping(value="/api/party/{partyId}")
    public GetPartyDetailRes getPartyDetail(@PathVariable long partyId){

        System.out.println("Controller 실행");
        System.out.println("partyId: "+partyId);

        return partyService.getPartyDetail(partyId);
    }
}
