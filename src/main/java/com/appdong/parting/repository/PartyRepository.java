package com.appdong.parting.repository;

import com.appdong.parting.data.entity.PartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<PartyEntity, Long> {
}
