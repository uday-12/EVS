package com.rgukt.evs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgukt.evs.entity.CandidateEntity;



public interface CandidateRepo extends JpaRepository<CandidateEntity,Integer>{

}
