package com.appdong.parting.controller;

import com.appdong.parting.config.BaseResponse;
import com.appdong.parting.data.dto.GetPartyMakedByMe;
import com.appdong.parting.data.entity.UserPartyMappingEntity;
import com.appdong.parting.service.UPMService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(
            value="내가 개설한 파티 조회",
            notes="내가 만든 파티를 조회해서 반환한다." +
                    "GetPartyMakedByMe Schema가 result에 담겨 반환된다." +
                    "현재는 로그인 기능이 구현되어있지 않아 userId를 1로 고정해놨으며 추후 login token을 전달받아 userId를 뽑아내 사용하는" +
                    "형태로 변경될 예정이다."
    )
    @GetMapping(value = "/api/my-party")
    public BaseResponse<ArrayList<GetPartyMakedByMe>> getPartiesMakedByMe(){

        long userId=1;

        return upmService.getPartiesMakedByMe(userId);
    }

    @PostMapping(value="/api/party/{partyId}/member")
    public BaseResponse<String> enterParty(@PathVariable("partyId") long partyId){
        long userId=3;


        return upmService.enterParty(userId,partyId);
    }
}
