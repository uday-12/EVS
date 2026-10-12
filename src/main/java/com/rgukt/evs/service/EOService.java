package com.rgukt.evs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgukt.evs.dao.EORepo;
import com.rgukt.evs.dao.VoterRepo;
import com.rgukt.evs.entity.VoterRegisterEntity;

@Service
public class EOService {

	@Autowired
	EORepo eoRepo;
	
	@Autowired
	VoterRepo voterRepo;
	
	public void approve(int vId, int electionVoterId)
	{
		VoterRegisterEntity vre = voterRepo.getById(vId);
		vre.setEoResponceVoter(true);
		vre.setVoterId(electionVoterId);
		voterRepo.save(vre);
	}
	
	public void disapprove(int vId)
	{
		VoterRegisterEntity vre = voterRepo.getById(vId);
		vre.setEoResponceVoter(false);
		vre.setVoterEORequest(false);
		voterRepo.save(vre);
	}
}
