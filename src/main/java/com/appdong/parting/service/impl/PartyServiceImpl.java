package com.appdong.parting.service.impl;

import com.appdong.parting.config.BaseResponse;
import com.appdong.parting.config.BaseResponseStatus;
import com.appdong.parting.data.dto.GetPartyDetailRes;
import com.appdong.parting.data.dto.PostOrUpdatePartyReq;
import com.appdong.parting.data.entity.*;
import com.appdong.parting.repository.*;
import com.appdong.parting.service.PartyService;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class PartyServiceImpl implements PartyService {

    PartyRepository partyRepository;
    UPMRepository upmRepository;
    CategoryRepository categoryRepository;
    CategoryDetailRepository categoryDetailRepository;
    PCDMRepository pcdmRepository;
    UserRepository userRepository;
    HashTagRepository hashTagRepository;

    public PartyServiceImpl(
            PartyRepository partyRepository,
            UPMRepository upmRepository,
            CategoryRepository categoryRepository,
            CategoryDetailRepository categoryDetailRepository,
            PCDMRepository pcdmRepository,
            UserRepository userRepository,
            HashTagRepository hashTagRepository
    ) {
        this.partyRepository = partyRepository;
        this.upmRepository = upmRepository;
        this.categoryRepository = categoryRepository;
        this.categoryDetailRepository = categoryDetailRepository;
        this.pcdmRepository = pcdmRepository;
        this.userRepository=userRepository;
        this.hashTagRepository=hashTagRepository;
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

    @Transactional
    @Override
    public BaseResponse updatePartyInfo(long userId, long partyId, PostOrUpdatePartyReq updatePartyReq) {
        PartyEntity partyEntity=partyRepository.getReferenceById(partyId);
        partyEntity.update(updatePartyReq);

        List<PartyCategoryDetailMappingEntity> PCDMEntityList=pcdmRepository.getReferenceByPartyId(partyId);
        List<Integer> currentCategoryDetailList=new ArrayList<>();
        List<Integer> newCategoryDetailIdList=updatePartyReq.getCategoryDetailIdList();
        // 1. new_categoryId가 기존 categoryId와 같은지 확인한다.
//              a) 기존 categoryId와 같은경우 상관 x
//                 1) 기존 categoryDetailId와 같은지 확인한다.
//              b) 기존 categoryId와 다른경우 상관있다.
        for(PartyCategoryDetailMappingEntity pcdmEntity:PCDMEntityList){
            currentCategoryDetailList.add(pcdmEntity.getCategoriesDetail().getCategoryDetailId());
        }



//        int categoryDetailId;
//        List<String> HashTag;                         // HashTag Domain 필요.

        return null;
    }

    @Override
    @Transactional
    public BaseResponse postParty(PostOrUpdatePartyReq postPartyReq, long userId) {
        //Todo categoryId 와 categoryDetailId가 연관된게 맞는지 check

        List<CategoriesDetailEntity> categoriesDetailEntityList = new ArrayList<>();
        List<Integer> request_categoryDetailIdList = new ArrayList<>();
        List<PartyCategoryDetailMappingEntity> partyCategoryDetailMappingEntityList = new ArrayList<>();

        try {
            request_categoryDetailIdList = postPartyReq.getCategoryDetailIdList();
        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(BaseResponseStatus.DATABASE_ERROR);
        }

        if (request_categoryDetailIdList.size() < 1 || request_categoryDetailIdList.size() > 2) {
            return new BaseResponse(BaseResponseStatus.PARTY_CAN_HAS_TWO_OR_ONE_CATEGORY_DETAIL);
        }

        // 연관된 세부 카테고리정보를 받아옴.
        // 연관된 세부 카테고리 끼리 같은 테마를 가지는지를 확인
        for (int categoryDetailId : request_categoryDetailIdList) {
            CategoriesDetailEntity categoriesDetailEntity = categoryDetailRepository.getReferenceById(categoryDetailId);
            if (postPartyReq.getCategoryId() != categoriesDetailEntity.getCategoriesEntity().getCategoryId()) {
                return new BaseResponse(BaseResponseStatus.PARTY_CAN_HAS_ONE_CATEGORY);
            }
            categoriesDetailEntityList.add(categoriesDetailEntity);
        }


        List<HashTagsEntity> hashTagsEntityList;
        try {
            UsersEntity usersEntity = userRepository.getReferenceById(userId);
            PartyEntity partyEntity = new PartyEntity(postPartyReq);

            List<UserPartyMappingEntity> userPartyMappingEntityList = new ArrayList<>();
            userPartyMappingEntityList.add(new UserPartyMappingEntity(usersEntity, partyEntity, "NORMAL_USER"));

            for (CategoriesDetailEntity categoriesDetailEntity : categoriesDetailEntityList) {
                PartyCategoryDetailMappingEntity partyCategoryDetailMappingEntity = new PartyCategoryDetailMappingEntity(partyEntity, categoriesDetailEntity);
                partyCategoryDetailMappingEntityList.add(partyCategoryDetailMappingEntity);
            }



            //HashTag의 경우 생성하고자 하는 HashTag가 테이블에 존재하는지 먼저 확인을 해줌.
            //HashTag가 있는경우 -> mapping에 넣어줌.
            //HashTag가 없는 경우 -> HashTag Table에 생성을 한 후에 mapping에 넣어줌.
            //임시로 테스트용
            hashTagsEntityList = new ArrayList<>();
            for (int i = 0; i < postPartyReq.getHashTagNameList().size(); i++) {
                HashTagsEntity hashTagsEntity = hashTagRepository.findByHashTagName(postPartyReq.getHashTagNameList().get(i));

                if (hashTagsEntity != null) { // 해시태그가 기존에 있는 경우.
                    hashTagsEntityList.add(hashTagsEntity);
                    System.out.println("ok");
                } else {        // 해시태그가 기존에 없는 경우
                    System.out.println("no");
                }
            }
            partyEntity.setHashTagsEntityList(hashTagsEntityList);
            partyEntity.setPartyCategoryDetailMappingEntities(partyCategoryDetailMappingEntityList);
            partyEntity.setUserpartymappingtableEntityList(userPartyMappingEntityList);

            partyRepository.save(partyEntity);
            System.out.println("hihi");

        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(BaseResponseStatus.DATABASE_ERROR);
        }

        System.out.println("이거뭐지?");
        return new BaseResponse(BaseResponseStatus.EMPTY_JWT);
    }

}
