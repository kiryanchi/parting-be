package com.appdong.parting.controller;

import com.appdong.parting.config.BaseResponse;
import com.appdong.parting.data.dto.GetPartyDetailRes;
import com.appdong.parting.service.PartyService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(
            value="party 상세 정보 조회",
            notes="partyId를 통해 파티 상세 정보를 조회한다.\n" +
                    "현재 지도기능과의 연동이 안되어있는 관계로 address,distance,distanceUnit의 경우 null로 반환된다.\n"+
                     "에러핸들링이 부족하다 우선 급한 기능부터 구현하고 에러핸들링을 추가할 예정이다."
    )
    @ApiImplicitParam(
            name = "partyId"
            , value = "파티 아이디"
            , required = true
            , dataType = "int"
            , paramType = "path"
            , defaultValue = "None"
            , example = "1")
    @GetMapping(value="/api/party/{partyId}")
    public GetPartyDetailRes getPartyDetail(@PathVariable long partyId){

        System.out.println("Controller 실행");
        System.out.println("partyId: "+partyId);

        return partyService.getPartyDetail(partyId);
    }

    @ApiOperation(
            value="party 삭제 기능",
            notes="partyId를 통해 파티를 삭제한다.\n" +
                    "party를 직접 개설한 user만 사용할 수 있는 기능이다.\n"+
                    "현재는 로그인 기능이 구현되어있지 않아 userId를 3으로 고정해놨으며 추후 login token을 전달받아 userId를 뽑아내 사용하는" +
                    "형태로 변경될 예정이다."
    )
    @ApiImplicitParam(
            name = "partyId"
            , value = "파티 아이디"
            , required = true
            , dataType = "int"
            , paramType = "path"
            , defaultValue = "None"
            , example = "1")
    @PatchMapping(value="/api/party/{partyId}/status")
    public BaseResponse deleteParty(@PathVariable long partyId){
        long userId=1;

        return partyService.deleteParty(userId,partyId);
    }
}
