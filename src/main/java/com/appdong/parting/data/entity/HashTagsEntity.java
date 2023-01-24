package com.appdong.parting.data.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="hashtags")
public class HashTagsEntity {

    @Id
    private java.math.BigInteger hashtagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="partyId")
    private PartyEntity party;

    private String hashtagName;
    private Timestamp createdAt;
    private String status;

}
