package com.appdong.parting.service.impl;

import com.appdong.parting.data.dto.GetPartyDetailRes;
import com.appdong.parting.data.entity.PartyEntity;
import com.appdong.parting.data.entity.UserPartyMappingEntity;
import com.appdong.parting.repository.PartyRepository;
import com.appdong.parting.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PartyServiceImpl implements PartyService {

    PartyRepository partyRepository;

    @Autowired
    public PartyServiceImpl(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }


    @Override
    public GetPartyDetailRes getPartyDetail(long partyId){
        System.out.println("파티 Service 실행");
        PartyEntity partyEntity=partyRepository.getReferenceById(partyId);

        List< UserPartyMappingEntity> mappingList=partyEntity.getUserpartymappingtableEntityList();

        for (int i=0; i<mappingList.size(); i++){
            System.out.println(mappingList.get(i).getUsers());
        }
        GetPartyDetailRes getPartyDetailRes=new GetPartyDetailRes(partyEntity);
        System.out.println(getPartyDetailRes);


        // partyImgUrl,curentPartyMemberCount,maxPartyMemberCount,hostReliability,deadLineDate,deadLineTime,partyTimeStr,location
        // address,distance,distanceUnit,partyDescription,memberList,category categoryDetail,hashTag,status
        return getPartyDetailRes;
    }

}
