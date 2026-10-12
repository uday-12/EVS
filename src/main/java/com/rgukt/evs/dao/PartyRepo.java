package com.rgukt.evs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgukt.evs.entity.PartyEntity;

public interface PartyRepo extends JpaRepository<PartyEntity,Integer>{
}
