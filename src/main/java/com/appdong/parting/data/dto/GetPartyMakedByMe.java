package com.appdong.parting.data.dto;

import com.appdong.parting.data.entity.PartyEntity;
import com.appdong.parting.data.entity.UsersEntity;
import lombok.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetPartyMakedByMe {
    // 실제 res가 될때는 List<getMyPartyRes>형태로 반환된다.

    private List<Parties> partiesList=new ArrayList<>();

    public GetPartyMakedByMe(UsersEntity usersEntity) {
        for (int i=0; i<usersEntity.getUserpartymappingtableEntityList().size(); i++){
            System.out.println("좀 알기라도하자");
            System.out.println(usersEntity.getUserpartymappingtableEntityList().size());
            partiesList.add(new Parties(usersEntity.getUserpartymappingtableEntityList().get(i).getParty()));
        }
    }
}
class Parties{
    private long partyId; //DB에서 BigInt형태로 저장될 예정이므로 여기서도 BigInteger를 이용해 구현된다.

    private String partyName;

    private String address;
    private int distance;
    private String distanceUnit;

    private int currentPartyMemberCount;
    private int maxPartyMemberCount;

    private String partyImgUrl;
    private Timestamp partyTime;
    private List<String> hashTag;

    private String status; // 완료인지, 파티가 진행중인지, 모집중인지, 진행완료인지 등을 반환한다.

    public Parties(PartyEntity partyEntity) {
        System.out.println(partyEntity);
        for(int i=0; i<partyEntity.getUserpartymappingtableEntityList().size(); i++){
            System.out.println(partyEntity.getUserpartymappingtableEntityList().get(i));
        }
//        List<UserPartyMappingEntity> mappingList=partyEntity.getUserpartymappingtableEntityList();
//        List<Member> tmpMemberList=new ArrayList<Member>();
//        for (int i=0; i<mappingList.size(); i++){
//            tmpMemberList.add(new Member(mappingList.get(i).getUsers()));
//        }

//        List<HashTagsEntity> hashTagsEntityList=partyEntity.getHashTagsEntityList();
//        List<String> hashTagNameList=new ArrayList<String>();
//        for(int i=0; i<hashTagsEntityList.size(); i++){
//            try{
//                hashTagNameList.add(hashTagsEntityList.get(i).getHashtagname());
//            }catch(Exception e){
//                System.out.println(e);
//                System.out.println(hashTagsEntityList.get(i).getHashtagname());
//            }
//        }

        this.partyId = partyEntity.getId();
        this.partyName = partyEntity.getPartyName();
        this.address = partyEntity.getAddress();
        this.distance = 0; //Todo 확인필요
        this.distanceUnit = distanceUnit; //TODO 확인필요
//        this.currentPartyMemberCount = tmpMemberList.size(); //Todo 확인필요
        this.currentPartyMemberCount = 0; //Todo 확인필요
        this.maxPartyMemberCount = partyEntity.getCapacity();
        this.partyImgUrl = partyEntity.getStoreImgUrl();
        this.partyTime = partyEntity.getDeadLine();
        this.hashTag = null;
        this.status = partyEntity.getStatus();
    }
}