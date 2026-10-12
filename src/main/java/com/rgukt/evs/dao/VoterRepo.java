package com.rgukt.evs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgukt.evs.entity.VoterRegisterEntity;

public interface VoterRepo extends JpaRepository<VoterRegisterEntity,Integer>{

}
