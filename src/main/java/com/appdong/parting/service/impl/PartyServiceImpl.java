package com.appdong.parting.service.impl;

import com.appdong.parting.config.BaseResponse;
import com.appdong.parting.config.BaseResponseStatus;
import com.appdong.parting.data.dto.GetPartyDetailRes;
import com.appdong.parting.data.entity.PartyEntity;
import com.appdong.parting.data.entity.UserPartyMappingEntity;
import com.appdong.parting.repository.PartyRepository;
import com.appdong.parting.repository.UPMRepository;
import com.appdong.parting.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PartyServiceImpl implements PartyService {

    PartyRepository partyRepository;
    UPMRepository upmRepository;

    public PartyServiceImpl(PartyRepository partyRepository, UPMRepository upmRepository) {
        this.partyRepository = partyRepository;
        this.upmRepository = upmRepository;
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

    @Override
    public BaseResponse deleteParty(long userId, long partyId) {
        try{
            UserPartyMappingEntity userPartyMappingEntity=upmRepository.getReferenceByUserIdAndPartyId(userId,partyId);
            if(!userPartyMappingEntity.getStatus().equals("host")){
                return new BaseResponse(BaseResponseStatus.USER_IS_NOT_HOST);
            }

            partyRepository.deleteParty(partyId,"INACTIVE");
            return new BaseResponse(BaseResponseStatus.SUCCESS);
        }catch(Exception e){
            System.out.println(e);
            return new BaseResponse(BaseResponseStatus.DATABASE_ERROR);
        }
    }

}
