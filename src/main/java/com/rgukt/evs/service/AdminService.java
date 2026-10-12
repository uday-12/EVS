package com.rgukt.evs.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rgukt.evs.dao.AdminRepo;
import com.rgukt.evs.dao.CandidateRepo;
import com.rgukt.evs.dao.EORepo;
import com.rgukt.evs.dao.ElectionRepo;
import com.rgukt.evs.dao.PartyRepo;
import com.rgukt.evs.entity.CandidateEntity;
import com.rgukt.evs.entity.EOEntity;
import com.rgukt.evs.entity.ElectionEntity;
import com.rgukt.evs.entity.PartyEntity;

@Service
public class AdminService {

	@Autowired
	AdminRepo rp;
	@Autowired
	ElectionRepo electionRepo;
	@Autowired
	PartyRepo partyRepo;
	@Autowired
	CandidateRepo candidateRepo;
	@Autowired
	EORepo eoRepo;

//	----------------------------------------------------------------LoginAdmin------------------------------------//
	public boolean validate(String email, String password) {
		if (rp.existsById(email) && rp.getById(email).getPassword().equals(password))
			return true;
		else
			return false;
	}

//	----------------------------------------------------election-----------------------------------------------//
	public List<ElectionEntity> getAllElection() {
		return electionRepo.findAll();
	}

	public void addElection(ElectionEntity electionEntity) {
		electionEntity.setAddCandidates(false);
		electionEntity.setAddParty(false);
		electionEntity.setResultsApprove(false);
		electionEntity.setStartElection(false);
		electionEntity.setStopElection(false);
		electionRepo.save(electionEntity);
	}

//--------------------------------------------------------------Party------------------------------------------------------------------//
	public List<PartyEntity> getAllParty() {
		return partyRepo.findAll();
	}

	public void addParty(InputStream inputStream, PartyEntity partyEntity, int electionId) throws IOException {
//		try {
//			partyEntity.setPartySymbol(Base64.getEncoder().encodeToString(file.getBytes()));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		partyEntity.setData(IOUtils.toByteArray(inputStream));
		partyEntity.setElectionId(electionId);
		partyRepo.save(partyEntity);
	}

	public void addPartyStatus(int electionId) {
		ElectionEntity el = electionRepo.getById(electionId);
		el.setAddParty(true);
		electionRepo.save(el);
	}

//-------------------------------------------------------------Candidate-----------------------------------------------------------------//
	public List<CandidateEntity> getAllCandidates() {
		return candidateRepo.findAll();
	}

	public void addCandidate(CandidateEntity candidateEntity, int electionId) {

		candidateEntity.setElectionId(electionId);
		candidateRepo.save(candidateEntity);
	}

	public void addElectionStatus(int electionId) {
		ElectionEntity els = electionRepo.getById(electionId);
		els.setAddCandidates(true);
		electionRepo.save(els);
	}

//-------------------------------------------------------adding EO---------------------------------------------------------------------//
	public void addEOEntity(EOEntity eoEntity, int electionId) {
		eoEntity.setElectionId(electionId);
		eoRepo.save(eoEntity);
	}

	public boolean EOLoginValidate(String email, String password) {
		List<EOEntity> list = eoRepo.findAll();
		for (EOEntity x : list) {
			if (x.getEoEmail().equals(email) && x.getEoPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
//--------------------------------------------------------start/stop enection----------------------------------------------------------//

	public void startElection(int electionId) {
		ElectionEntity els = electionRepo.getById(electionId);
		els.setStartElection(true);
		els.setStopElection(false);
		electionRepo.save(els);
	}

	public void stopElection(int electionId) {
		ElectionEntity els = electionRepo.getById(electionId);
		els.setStartElection(false);
		els.setStopElection(true);
		electionRepo.save(els);
	}

	public void approveResults(int electionId) {
		ElectionEntity els = electionRepo.getById(electionId);
		els.setResultsApprove(true);
		electionRepo.save(els);
	}

	public void addParty(String string, String string2, int electionVoterId, InputStream inputStream)
			throws IOException {
		PartyEntity pe = new PartyEntity();
		pe.setData(IOUtils.toByteArray(inputStream));
		pe.setElectionId(electionVoterId);
		pe.setPartyLeader(string2);
		pe.setPartyName(string2);
		partyRepo.save(pe);
	}

	public PartyEntity getParty() {

		return partyRepo.getById(42);
	}

	public void addParty(PartyEntity partyEntity, int electionId) {
		partyEntity.setElectionId(electionId);
		partyRepo.save(partyEntity);
	}

	public void addCandidate(CandidateEntity candidateEntity, int electionId, InputStream inputStream1,
			InputStream inputStream2) throws IOException {
		candidateEntity.setCandidateImage(IOUtils.toByteArray(inputStream1));
		candidateEntity.setPartyImage(IOUtils.toByteArray(inputStream2));
		candidateEntity.setElectionId(electionId);
		candidateRepo.save(candidateEntity);
	}
}
