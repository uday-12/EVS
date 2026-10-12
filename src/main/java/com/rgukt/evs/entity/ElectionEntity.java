package com.rgukt.evs.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ElectionEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int electionId;
	private String electionName;
	private String state;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
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
	public int getElectionId() {
		return electionId;
	}
	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}
	
}
