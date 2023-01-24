package com.appdong.parting.repository;

import com.appdong.parting.data.entity.UserPartyMappingEntity;
import com.appdong.parting.data.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UPMRepository extends JpaRepository<UserPartyMappingEntity, Long> {

    @Query("select upm from UserPartyMappingEntity upm where upm.users.id=:userId and upm.status='host'")
    public List<UserPartyMappingEntity> getPartiesMakedByMe(@Param("userId") long userId);

    @Query("select upm from UserPartyMappingEntity upm where upm.users.id=:userId and upm.party.id=:partyId")
    public UserPartyMappingEntity getReferenceByUserIdAndPartyId(@Param("userId") long userId,@Param("partyId") long partyId);
    @Transactional
    @Modifying
    @Query("delete from UserPartyMappingEntity upm where upm.users.id=:userId and upm.party.id=:partyId")
    public void withdrawPartyByUserIdAndPartyId(long userId,long partyId);
}
