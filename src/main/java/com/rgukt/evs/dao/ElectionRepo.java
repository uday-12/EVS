package com.rgukt.evs.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rgukt.evs.entity.ElectionEntity;

public interface ElectionRepo extends JpaRepository<ElectionEntity,Integer>{

}
