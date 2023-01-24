package com.appdong.parting.service.impl;

import com.appdong.parting.data.dto.GetPartyMakedByMe;
import com.appdong.parting.data.entity.PartyEntity;
import com.appdong.parting.data.entity.UserPartyMappingEntity;
import com.appdong.parting.data.entity.UsersEntity;
import com.appdong.parting.repository.UPMRepository;
import com.appdong.parting.repository.UserRepository;
import com.appdong.parting.service.UPMService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UPMServiceImpl implements UPMService {
    UPMRepository upmRepository;

    public UPMServiceImpl(UPMRepository upmRepository) {
        this.upmRepository = upmRepository;
    }

    public ArrayList<GetPartyMakedByMe> getPartiesMakedByMe(long userId){
        List<UserPartyMappingEntity> userPartyMappingEntityList=upmRepository.getPartiesMakedByMe(userId);//잠만 이거 여러개면 어애되는거지?

        System.out.println(userPartyMappingEntityList);
        ArrayList<GetPartyMakedByMe> getPartyMakedByMeList=new ArrayList<>();
        for(UserPartyMappingEntity userPartyMappingEntity:userPartyMappingEntityList){
            PartyEntity partyEntity=userPartyMappingEntity.getParty();
            getPartyMakedByMeList.add(new GetPartyMakedByMe(partyEntity));
        }


        return getPartyMakedByMeList;
    }
}
