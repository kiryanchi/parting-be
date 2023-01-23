package com.appdong.parting.service.impl;

import com.appdong.parting.data.dto.GetPartyDdayRes;
import com.appdong.parting.data.dto.RetrievePartiesByUserIdRes;
import com.appdong.parting.data.entity.PartyEntity;
import com.appdong.parting.data.entity.UsersEntity;
import com.appdong.parting.repository.UserRepository;
import com.appdong.parting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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

        LocalDate today = LocalDate.now(ZoneId.of("Asia/Seoul"));
        Date todayDate= java.sql.Date.valueOf(today);
        System.out.println(todayDate.toString());

        UsersEntity usersEntity=userRepository.getReferenceByIdForDday(userId,todayDate);
        //Todo usersEntity가 null일 때 error handling
        //Todo query가 제대로 안된다..?

        System.out.println("Entity");
        System.out.println(usersEntity);

        List<PartyEntity> partyList=new ArrayList<PartyEntity>();
        GetPartyDdayRes getPartyDdayRes = null;

        for(int i=0; i<usersEntity.getUserpartymappingtableEntityList().size(); i++){
            System.out.println("어디까지 가니?"+i);
            partyList.add(usersEntity.getUserpartymappingtableEntityList().get(i).getParty());
        }

        getPartyDdayRes=new GetPartyDdayRes(partyList);


        System.out.println("DTO");
        System.out.println(getPartyDdayRes);
        return getPartyDdayRes;
    }

    @Override
    public ArrayList<RetrievePartiesByUserIdRes> getEnteredParties(long userId) {

        UsersEntity usersEntity=userRepository.getEnteredParties(userId);

        System.out.println(usersEntity);
        ArrayList<PartyEntity> partyEntityArrayList=new ArrayList<>();

        for(int i=0; i<usersEntity.getUserpartymappingtableEntityList().size(); i++){
            partyEntityArrayList.add(usersEntity.getUserpartymappingtableEntityList().get(i).getParty());
        }

        ArrayList<RetrievePartiesByUserIdRes> retrievePartiesByUserIdResArray=new ArrayList<>();
        for(int i=0; i<partyEntityArrayList.size();i++){
            RetrievePartiesByUserIdRes retrievePartiesByUserIdRes=new RetrievePartiesByUserIdRes(partyEntityArrayList.get(i));
            retrievePartiesByUserIdResArray.add(retrievePartiesByUserIdRes);
        }



        return retrievePartiesByUserIdResArray;
    }
}
