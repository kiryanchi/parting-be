package com.appdong.parting.controller;

import com.appdong.parting.data.dto.GetPartyMakedByMe;
import com.appdong.parting.service.UPMService;
import org.springframework.web.bind.annotation.GetMapping;
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
}
