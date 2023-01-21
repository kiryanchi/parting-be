package com.appdong.parting.controller;

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
}
