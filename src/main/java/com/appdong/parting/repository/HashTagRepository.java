package com.appdong.parting.repository;

import com.appdong.parting.data.entity.HashTagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagRepository extends JpaRepository<HashTagsEntity,Long> {

    HashTagsEntity findByHashTagName(String hashTagName);
}
