package com.rgukt.evs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgukt.evs.entity.EOEntity;

public interface EORepo extends JpaRepository<EOEntity, Integer> {

}
