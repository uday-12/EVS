package com.rgukt.evs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class CandidateEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int candidateId;
	private int electionId;
	private String candidateName;
	private int candidateAge;
	private String candidateAddress;
	private String candidateParty;
	private String candidateConstituency;
	private long candidateNumber;
	private boolean voteStatus;
	private int vote;
	@Lob
	private byte[] candidateImage;
	@Lob
	private byte[] partyImage;
	private String stringCandidateImage;
	private String stringPartyImage;
	public String getStringCandidateImage() {
		return stringCandidateImage;
	}
	public void setStringCandidateImage(String stringCandidateImage) {
		this.stringCandidateImage = stringCandidateImage;
	}
	public String getStringPartyImage() {
		return stringPartyImage;
	}
	public void setStringPartyImage(String stringPartyImage) {
		this.stringPartyImage = stringPartyImage;
	}
	public byte[] getCandidateImage() {
		return candidateImage;
	}
	public void setCandidateImage(byte[] candidateImage) {
		this.candidateImage = candidateImage;
	}
	public byte[] getPartyImage() {
		return partyImage;
	}
	public void setPartyImage(byte[] partyImage) {
		this.partyImage = partyImage;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public int getElectionId() {
		return electionId;
	}
	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public int getCandidateAge() {
		return candidateAge;
	}
	public void setCandidateAge(int candidateAge) {
		this.candidateAge = candidateAge;
	}
	public String getCandidateAddress() {
		return candidateAddress;
	}
	public void setCandidateAddress(String candidateAddress) {
		this.candidateAddress = candidateAddress;
	}
	public String getCandidateParty() {
		return candidateParty;
	}
	public void setCandidateParty(String candidateParty) {
		this.candidateParty = candidateParty;
	}
	public String getCandidateConstituency() {
		return candidateConstituency;
	}
	public void setCandidateConstituency(String candidateConstituency) {
		this.candidateConstituency = candidateConstituency;
	}
	public long getCandidateNumber() {
		return candidateNumber;
	}
	public void setCandidateNumber(long candidateNumber) {
		this.candidateNumber = candidateNumber;
	}
	public boolean isVoteStatus() {
		return voteStatus;
	}
	public void setVoteStatus(boolean voteStatus) {
		this.voteStatus = voteStatus;
	}
	
	
	
}
