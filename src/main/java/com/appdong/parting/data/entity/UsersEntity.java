package com.appdong.parting.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nickName;
    private String profileImgUrl;
    private String sex;         // M F
    private Date birth;
    private String tel;         // 01085050877형태로 저장
    private int reliability;    // 신뢰도 0~100%

    @OneToMany(mappedBy = "users")
    private List<UserPartyMappingEntity> userpartymappingtableEntityList;

    public UsersEntity(UsersEntity users) {
        this.id = users.id;
        this.nickName = users.nickName;
        this.profileImgUrl = users.profileImgUrl;
        this.sex = users.sex;
        this.birth = users.birth;
        this.tel = users.tel;
        this.reliability = users.reliability;
        this.userpartymappingtableEntityList = users.userpartymappingtableEntityList;
    }


}