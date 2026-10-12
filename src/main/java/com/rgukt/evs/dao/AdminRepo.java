package com.rgukt.evs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgukt.evs.entity.AdminEntity;

public interface AdminRepo extends JpaRepository <AdminEntity, String>{

}
