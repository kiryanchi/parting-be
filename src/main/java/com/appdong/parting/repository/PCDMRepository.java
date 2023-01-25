package com.appdong.parting.repository;

import com.appdong.parting.data.entity.PartyCategoryDetailMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PCDMRepository extends JpaRepository<PartyCategoryDetailMappingEntity,Long> {

    @Query("SELECT pcdm FROM PartyCategoryDetailMappingEntity pcdm WHERE pcdm.party.id=:partyId")
    List<PartyCategoryDetailMappingEntity> getReferenceByPartyId(long partyId);
}
