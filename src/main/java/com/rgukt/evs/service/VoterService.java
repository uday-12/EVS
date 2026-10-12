package com.rgukt.evs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgukt.evs.dao.CandidateRepo;
import com.rgukt.evs.dao.ElectionRepo;
import com.rgukt.evs.dao.VoterRepo;
import com.rgukt.evs.entity.CandidateEntity;
import com.rgukt.evs.entity.ElectionEntity;
import com.rgukt.evs.entity.VoterRegisterEntity;


@Service
public class VoterService {

	@Autowired
	VoterRepo voterRepo;
	@Autowired
	ElectionRepo electionRepo;
	@Autowired
	CandidateRepo candidateRepo;
	
	
//	----------------------------------------Register -----------------------------------------------//
	public void register(VoterRegisterEntity voterRegister)
	{
//		voterRegister.setVoterId(0);
		voterRepo.save(voterRegister);
	}
	public List<VoterRegisterEntity> getAllVoters()
	{
		return voterRepo.findAll();
	}
	
	public boolean validate(String email,String password)
	{

		List<VoterRegisterEntity>list = voterRepo.findAll();
		for(VoterRegisterEntity x: list)
		{
			if(x.getVoterEmail().equals(email) && x.getVoterPassword().equals(password))
			{	
				return true;
			}
		}
		return false;
	}
	
	public void voterEORequest(int vId)
	{
		VoterRegisterEntity vr = voterRepo.getById(vId);
		vr.setVoterEORequest(true);
		vr.setEoResponceVoter(false);
		voterRepo.save(vr);
	}
//------------------------------------------------checking---------------------------------------------------//
	public boolean eoResponceVoterCheck(int vId)
	{
		VoterRegisterEntity vr = voterRepo.getById(vId);
		if(vr.isEoResponceVoter() == true)
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean electionStartCheck(int electionId)
	{
		ElectionEntity el = electionRepo.getById(electionId);
		if(el.isStartElection() == true)
		{
			return true;
		}
		else {
			return false;
		}
	}
	
//----------------------------------------------------is voted----------------------------------------------------------------//	
	public VoterRegisterEntity findById(int vId)
	{
		VoterRegisterEntity vr = voterRepo.getById(vId);
		return vr;
	}
	
	public boolean isVoted(int vId)
	{
		VoterRegisterEntity vr = voterRepo.getById(vId);
		if(vr.isVoteStatus()==false)
		{
			return false;
		}
		else {
			return true;
		}
	}
	public void voteRegister(int candidateId)
	{
		CandidateEntity ce = candidateRepo.getById(candidateId);
		int votes = ce.getVote();
		votes++;
		ce.setVote(votes);
		candidateRepo.save(ce);
	}
	public void voteStatus(int vId)
	{
		VoterRegisterEntity vr = voterRepo.getById(vId);
		vr.setVoteStatus(true);
		voterRepo.save(vr);
	}
}
