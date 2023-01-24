package com.appdong.parting.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="userInterestMapping")
public class UserInterestMappingTable {
        @Id
        private long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="userId")
        private UsersEntity users;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="interestId")
        private InterestDetailsEntity interests;
        private Timestamp createdAt;
        private Timestamp updatedAt;
        private String status;


}
