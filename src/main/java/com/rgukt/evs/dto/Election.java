package com.rgukt.evs.dto;

import java.time.LocalDate;

public class Election {

	private int electionId;
	private String electionName;
	private String state;
	private LocalDate date;
	private String constituency;
	private boolean resultsApprove;
	
	private boolean addParty;
	private boolean addCandidates;
	
	private boolean startElection;
	private boolean stopElection;
	
	
	public boolean isStartElection() {
		return startElection;
	}
	public void setStartElection(boolean startElection) {
		this.startElection = startElection;
	}
	public boolean isStopElection() {
		return stopElection;
	}
	public void setStopElection(boolean stopElection) {
		this.stopElection = stopElection;
	}
	public boolean isAddParty() {
		return addParty;
	}
	public void setAddParty(boolean addParty) {
		this.addParty = addParty;
	}
	public boolean isAddCandidates() {
		return addCandidates;
	}
	public void setAddCandidates(boolean addCandidates) {
		this.addCandidates = addCandidates;
	}
	public int getElectionId() {
		return electionId;
	}
	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}
	public String getElectionName() {
		return electionName;
	}
	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public boolean isResultsApprove() {
		return resultsApprove;
	}
	public void setResultsApprove(boolean resultsApprove) {
		this.resultsApprove = resultsApprove;
	}
	
}
