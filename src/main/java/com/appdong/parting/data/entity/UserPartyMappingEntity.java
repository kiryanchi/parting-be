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

    @Override
    public String toString() {
        return "UserPartyMappingEntity{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }

    public UserPartyMappingEntity() {
    }

    public UserPartyMappingEntity(UsersEntity users, PartyEntity party, String status) {
        this.id = id;
        this.users = users;
        this.party = party;
        this.status = status;
    }
}
