package com.appdong.parting.data.models;

import com.appdong.parting.data.entity.UsersEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
    private long userId;
    private String profileUrl;
    private String userName;

    public Member(UsersEntity usersEntity){
        this.userId=usersEntity.getId();
        this.profileUrl=usersEntity.getProfileImgUrl();
        this.userName=usersEntity.getNickName();
    }
}
