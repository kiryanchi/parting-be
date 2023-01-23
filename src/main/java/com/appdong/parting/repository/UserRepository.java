package com.appdong.parting.repository;

import com.appdong.parting.data.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public interface UserRepository extends JpaRepository<UsersEntity, Long> {
    @Query("select u from UsersEntity u " +
            "left join fetch UserPartyMappingEntity upm on upm.users.id=u.id " +
            "left join fetch PartyEntity p on upm.party.id=p.id " +
            "where u.id=:userId and Date(p.partyStartDateTime)=:today")
    public UsersEntity getReferenceByIdForDday(@Param("userId") long userId, @Param("today") Date today);


    @Query("select u from UsersEntity u " +
            "left join fetch UserPartyMappingEntity upm on upm.users.id=u.id " +
            "left join fetch PartyEntity p on upm.party.id=p.id " +
            "where upm.users.id=:userId")
    public UsersEntity getEnteredParties(@Param("userId") long userId);
}
