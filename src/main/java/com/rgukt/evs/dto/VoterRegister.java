package com.rgukt.evs.dto;

public class VoterRegister {

	private int vId;
	private String voterName;
	private String voterDOB;
	private String voterGender;
	private String voterAddress;
	private Long voterNumber;
	private String voterDistrict;
	private String voterEmail;
	private String voterPassword;
	private String voterRepeatPassword;
	private int voterId;
	private boolean voterEORequest;
	private boolean eoResponceVoter;
	
	private boolean voteStatus;
	private int electionId;
	
	
	public boolean isEoResponceVoter() {
		return eoResponceVoter;
	}
	public void setEoResponceVoter(boolean eoResponceVoter) {
		this.eoResponceVoter = eoResponceVoter;
	}
	public String getVoterRepeatPassword() {
		return voterRepeatPassword;
	}
	public void setVoterRepeatPassword(String voterRepeatPassword) {
		this.voterRepeatPassword = voterRepeatPassword;
	}
	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	public String getVoterName() {
		return voterName;
	}
	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}
	public String getVoterDOB() {
		return voterDOB;
	}
	public void setVoterDOB(String voterDOB) {
		this.voterDOB = voterDOB;
	}
	public String getVoterGender() {
		return voterGender;
	}
	public void setVoterGender(String voterGender) {
		this.voterGender = voterGender;
	}
	public String getVoterAddress() {
		return voterAddress;
	}
	public void setVoterAddress(String voterAddress) {
		this.voterAddress = voterAddress;
	}
	public Long getVoterNumber() {
		return voterNumber;
	}
	public void setVoterNumber(Long voterNumber) {
		this.voterNumber = voterNumber;
	}
	public String getVoterDistrict() {
		return voterDistrict;
	}
	public void setVoterDistrict(String voterDistrict) {
		this.voterDistrict = voterDistrict;
	}
	public String getVoterEmail() {
		return voterEmail;
	}
	public void setVoterEmail(String voterEmail) {
		this.voterEmail = voterEmail;
	}
	public String getVoterPassword() {
		return voterPassword;
	}
	public void setVoterPassword(String voterPassword) {
		this.voterPassword = voterPassword;
	}
	public int getVoterId() {
		return voterId;
	}
	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}
	public boolean isVoterEORequest() {
		return voterEORequest;
	}
	public void setVoterEORequest(boolean voterEORequest) {
		this.voterEORequest = voterEORequest;
	}
	public boolean isVoteStatus() {
		return voteStatus;
	}
	public void setVoteStatus(boolean voteStatus) {
		this.voteStatus = voteStatus;
	}
	public int getElectionId() {
		return electionId;
	}
	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}
	
}
