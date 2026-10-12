package com.rgukt.evs.dto;

public class Candidate {
	
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
