package com.appdong.parting.service.impl;

import com.appdong.parting.config.BaseResponse;
import com.appdong.parting.config.BaseResponseStatus;
import com.appdong.parting.data.dto.GetPartyMakedByMe;
import com.appdong.parting.data.entity.PartyEntity;
import com.appdong.parting.data.entity.UserPartyMappingEntity;
import com.appdong.parting.data.entity.UsersEntity;
import com.appdong.parting.repository.PartyRepository;
import com.appdong.parting.repository.UPMRepository;
import com.appdong.parting.repository.UserRepository;
import com.appdong.parting.service.UPMService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UPMServiceImpl implements UPMService {
    UPMRepository upmRepository;
    UserRepository userRepository;
    PartyRepository partyRepository;

    public UPMServiceImpl(UPMRepository upmRepository, UserRepository userRepository, PartyRepository partyRepository) {
        this.upmRepository = upmRepository;
        this.userRepository = userRepository;
        this.partyRepository = partyRepository;
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

    public BaseResponse<String> enterParty(long userId, long partyId){
        try{
            UsersEntity usersEntity=userRepository.getReferenceById(userId);
            PartyEntity partyEntity=partyRepository.getReferenceById(partyId);

            UserPartyMappingEntity userPartyMappingEntity=new UserPartyMappingEntity(usersEntity,partyEntity,"normal_host");
            UserPartyMappingEntity response=upmRepository.save(userPartyMappingEntity);

            System.out.println("response");
            System.out.println(response);

            return new BaseResponse<>(""+userId+"번 유저가 "+partyId+"번 파티에 입장하였습니다.");
        }catch(DataIntegrityViolationException dataIntegrityViolationException){
            System.out.println(dataIntegrityViolationException);
            return new BaseResponse(BaseResponseStatus.PARTY_OR_USER_ID_INVALID);
        }catch(Exception e){
            System.out.println(e);
            return new BaseResponse<>(BaseResponseStatus.DATABASE_ERROR);
        }
    }
}
