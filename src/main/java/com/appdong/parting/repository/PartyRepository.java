package com.appdong.parting.repository;

import com.appdong.parting.data.entity.PartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PartyRepository extends JpaRepository<PartyEntity, Long> {

    @Modifying
    @Transactional
    @Query("update PartyEntity p set p.status=:status")
    void deleteParty(long partyId,String status);

}
