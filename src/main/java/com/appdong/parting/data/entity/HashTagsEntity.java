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
    private long hashtagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="partyId")
    private PartyEntity party;

    private String hashTagName;
    private Timestamp createdAt;
    private String status;

    @Override
    public String toString() {
        return "HashTagsEntity{" +
                "hashtagId=" + hashtagId +
                ", hashTagName='" + hashTagName + '\'' +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                '}';
    }
}
