package com.appdong.parting.controller;

import com.appdong.parting.config.BaseResponse;
import com.appdong.parting.config.BaseResponseStatus;
import com.appdong.parting.data.dto.GetPartyMakedByMe;
import com.appdong.parting.data.entity.UserPartyMappingEntity;
import com.appdong.parting.service.UPMService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UPMController {
    private UPMService upmService;

    public UPMController(UPMService upmService) {
        this.upmService = upmService;
    }

    @ApiOperation(
            value = "내가 개설한 파티 조회",
            notes = "내가 만든 파티를 조회해서 반환한다." +
                    "GetPartyMakedByMe Schema가 result에 담겨 반환된다." +
                    "현재는 로그인 기능이 구현되어있지 않아 userId를 1로 고정해놨으며 추후 login token을 전달받아 userId를 뽑아내 사용하는" +
                    "형태로 변경될 예정이다."
    )
    @GetMapping(value = "/api/my-party")
    public BaseResponse<ArrayList<GetPartyMakedByMe>> getPartiesMakedByMe() {

        long userId = 1;

        return upmService.getPartiesMakedByMe(userId);
    }

    @PostMapping(value = "/api/party/{partyId}/member")
    public BaseResponse<String> enterParty(@PathVariable("partyId") long partyId) {
        long userId = 3;


        return upmService.enterParty(userId, partyId);
    }

    @ApiOperation(
            value = "파티 탈퇴하기 API",
            notes = "파티 탈퇴하기 API이다. normal_member만이 탈퇴할 수 있으며" +
                    "host는 탈퇴할 수 없다.(파티를 삭제해야한다.)" +
                    "현재는 로그인 기능이 구현되어있지 않아 userId를 3으로 고정해놨으며 추후 login token을 전달받아 userId를 뽑아내 사용하는" +
                    "형태로 변경될 예정이다."
    )
    @ApiImplicitParam(
            name = "partyId"
            , value = "파티 아이디"
            , required = true
            , dataType = "long"
            , paramType = "path"
            , defaultValue = "None"
            , example = "2")
    @ApiResponses({
            @ApiResponse(
                    code = 1000
                    , message = "요청에 성공하였습니다."
            ),
            @ApiResponse(
                    code = 4000
                    , message = "데이터베이스 에러입니다."
            ),
            @ApiResponse(
                    code = 5001
                    , message = "host는 파티를 나갈 수 없습니다. 파티를 삭제해주세요"
            ),
            @ApiResponse(
                    code = 5002
                    , message = "해당 유저가 해당 파티에 속해있지 않습니다."
            )
    })
    @DeleteMapping(value = "/api/party/{partyId}/member")

    public BaseResponse withdrawParty(@PathVariable("partyId") long partyId) {
        long userId = 3;

        return upmService.withdrawParty(userId, partyId);
    }
}
