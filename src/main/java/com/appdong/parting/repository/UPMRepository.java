package com.appdong.parting.repository;

import com.appdong.parting.data.entity.UserPartyMappingEntity;
import com.appdong.parting.data.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UPMRepository extends JpaRepository<UserPartyMappingEntity, Long> {

    @Query("select upm from UserPartyMappingEntity upm where upm.users.id=:userId and upm.status='host'")
    public List<UserPartyMappingEntity> getPartiesMakedByMe(@Param("userId") long userId);

}
