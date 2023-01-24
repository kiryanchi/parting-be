package com.appdong.parting.data.dto;

import com.appdong.parting.data.entity.PartyEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class GetPartyDdayRes {
    // 실제 res될때는 list로 뽑아서 보내준다.
    private List<PartyDdayInfo> partyDdayInfoList;

    public GetPartyDdayRes(List<PartyEntity> partyEntityList){
        List<PartyDdayInfo> partyDdayInfos=new ArrayList<PartyDdayInfo>();
        for(int i=0; i<partyEntityList.size(); i++){
            try{
                partyDdayInfos.add(new PartyDdayInfo(partyEntityList.get(i)));
            }catch(Exception e){
                System.out.println(e);  //status =active가 아닌경우
            }
        }

        partyDdayInfoList=partyDdayInfos;
    }
}

@ToString
@Getter
@Setter
class PartyDdayInfo{
    private long partyId;
    private String partyName;
    private int dday;

    public PartyDdayInfo(PartyEntity partyEntity) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr=new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
        String partyDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(partyEntity.getPartyStartDateTime().getTime());

        Date partyDate = new Date(dateFormat.parse(partyDateStr).getTime());
        Date today = new Date(dateFormat.parse(todayStr).getTime());
        long calDiff=partyDate.getTime() - today.getTime();

        System.out.println(partyDate);

        this.partyId = partyEntity.getId();
        this.partyName = partyEntity.getPartyName();
        int Ddays = (int) (calDiff / ( 24*60*60*1000));
        this.dday = Ddays;
    }
}
