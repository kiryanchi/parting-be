package com.appdong.parting.data.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="userPartyMapping")
public class UserPartyMappingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private UsersEntity users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="partyId")
    private PartyEntity party;

    private String status;

}
