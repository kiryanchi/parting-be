package com.appdong.parting.controller;

import com.appdong.parting.data.dto.GetPartyDdayRes;
import com.appdong.parting.data.dto.GetPartyMakedByMe;
import com.appdong.parting.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(
            value="남은 파티 d-day조회 API",
            notes="login token을 던져주면 거기서 userId를 뽑아내는 형태가 되어야하지만 아직 로그인 기능이 구현되어있지 않으므로.\n" +
                    "임시로 userId=1이라 가정하고 서버기능이 구현되어있다..\n"+
                    "에러핸들링이 부족하다 우선 급한 기능부터 구현하고 에러핸들링을 추가할 예정이다."
    )
    @GetMapping(value = "/api/party/d-day")
    public GetPartyDdayRes getPartyDdayByUserId(){

        long userId=1; //Todo 일단은 1로 고정

        return userService.getPartyDdayByUserId(userId);
    }

}
