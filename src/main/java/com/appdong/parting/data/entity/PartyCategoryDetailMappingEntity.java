package com.appdong.parting.data.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class PartyCategoryDetailMappingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="partyId")
    PartyEntity party;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoryDetailId")
    CategoriesDetailEntity categoriesDetail;

    public PartyCategoryDetailMappingEntity() {
    }

    public PartyCategoryDetailMappingEntity(PartyEntity party, CategoriesDetailEntity categoriesDetail) {
        this.party = party;
        this.categoriesDetail = categoriesDetail;
    }
}
