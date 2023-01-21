package com.appdong.parting.service.impl;

import com.appdong.parting.data.dto.GetPartyDdayRes;
import com.appdong.parting.data.entity.PartyEntity;
import com.appdong.parting.data.entity.UsersEntity;
import com.appdong.parting.repository.UserRepository;
import com.appdong.parting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public GetPartyDdayRes getPartyDdayByUserId(long userId) {

        UsersEntity usersEntity=userRepository.getReferenceById(userId);
        List<PartyEntity> partyList=new ArrayList<PartyEntity>();
        GetPartyDdayRes getPartyDdayRes = null;

        for(int i=0; i<usersEntity.getUserpartymappingtableEntityList().size(); i++){
            System.out.println("어디까지 가니?"+i);
            partyList.add(usersEntity.getUserpartymappingtableEntityList().get(i).getParty());
        }

        getPartyDdayRes=new GetPartyDdayRes(partyList);

        System.out.println("Entity");
        System.out.println(usersEntity);
        System.out.println("DTO");
        System.out.println(getPartyDdayRes);
        return getPartyDdayRes;
    }

}
